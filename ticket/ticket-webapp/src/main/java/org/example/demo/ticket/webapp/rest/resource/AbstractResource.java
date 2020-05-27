package org.example.demo.ticket.webapp.rest.resource;

import org.example.demo.ticket.business.factory.contract.ManagerFactory;

// cette classe abstraite injecte la ManagerFactory.
// Celle-ci est difficilement injectable par configuration ou annotation.
// Dans le cas présent d'une initialisation de l'IoC mixte (java et annotation), 
// NE PAS OUBLIER D'IMPORTER LE FICHIER applicationContext.xml de ticket-wepapp
// Erreur de Tomcat:
// java.lang.NullPointerException
//		org.example.demo.ticket.webapp.rest.resource.projet.ProjetResource.getProjets(ProjetResource.java:49)
public abstract class AbstractResource {

	private static ManagerFactory mgrFactory;

	public static void setManagerFactory(ManagerFactory pMgrFactory) {
		mgrFactory = pMgrFactory;
	}
	
	protected static ManagerFactory getManagerFactory() {
		return AbstractResource.mgrFactory;
	}

}

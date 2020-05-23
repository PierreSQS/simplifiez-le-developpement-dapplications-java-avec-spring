package org.example.demo.ticket.webapp.rest.resource;

import org.example.demo.ticket.business.factory.contract.ManagerFactory;

public abstract class AbstractResource {

	private static ManagerFactory mgrFactory;

	public static void setMgrFactory(ManagerFactory pMgrFactory) {
		mgrFactory = pMgrFactory;
	}
	
	protected static ManagerFactory getManagerFactory() {
		return AbstractResource.mgrFactory;
	}

}

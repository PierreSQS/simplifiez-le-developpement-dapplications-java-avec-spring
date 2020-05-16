package org.example.demo.ticket.business.factory;

import org.example.demo.ticket.business.manager.ProjetManager;

public class ManagerFactory {

	public static ProjetManager getProjetManager() {
		return new ProjetManager();
	}

}

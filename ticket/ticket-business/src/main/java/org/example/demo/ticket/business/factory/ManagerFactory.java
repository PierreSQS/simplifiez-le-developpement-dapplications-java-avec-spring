package org.example.demo.ticket.business.factory;

import org.example.demo.ticket.business.manager.ProjetManager;
import org.example.demo.ticket.business.manager.TicketManager;

public class ManagerFactory {

	private ProjetManager projetMgr;
	
	private TicketManager ticketMgr;
	
	public void setProjetMgr(ProjetManager projetMgr) {
		this.projetMgr = projetMgr;
	}

	public TicketManager getTicketMgr() {
		return ticketMgr;
	}

	public void setTicketMgr(TicketManager ticketMgr) {
		this.ticketMgr = ticketMgr;
	}

	public ProjetManager getProjetManager() {
		return projetMgr;
	}
	
	public TicketManager getTicketManager() {
		return ticketMgr;
	}

}

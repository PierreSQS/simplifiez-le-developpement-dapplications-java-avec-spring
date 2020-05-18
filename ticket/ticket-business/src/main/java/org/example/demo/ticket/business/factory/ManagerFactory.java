package org.example.demo.ticket.business.factory;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.TicketManager;

public class ManagerFactory {

	private org.example.demo.ticket.business.manager.contract.ProjetManager projetMgr;
	
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

	public org.example.demo.ticket.business.manager.contract.ProjetManager getProjetManager() {
		return projetMgr;
	}
	
	public TicketManager getTicketManager() {
		return ticketMgr;
	}

}

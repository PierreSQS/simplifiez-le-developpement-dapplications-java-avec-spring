package org.example.demo.ticket.business.factory;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TickteManager;

public class ManagerFactory {

	private org.example.demo.ticket.business.manager.contract.ProjetManager projetMgr;
	
	private TickteManager ticketMgr;
	
	public void setProjetMgr(ProjetManager projetMgr) {
		this.projetMgr = projetMgr;
	}

	public TickteManager getTicketMgr() {
		return ticketMgr;
	}

	public void setTicketMgr(TickteManager ticketMgr) {
		this.ticketMgr = ticketMgr;
	}

	public org.example.demo.ticket.business.manager.contract.ProjetManager getProjetManager() {
		return projetMgr;
	}
	
	public TickteManager getTicketManager() {
		return ticketMgr;
	}

}

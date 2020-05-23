package org.example.demo.ticket.business.factory.impl;

import org.example.demo.ticket.business.factory.contract.ManagerFactory;
import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TickteManager;

public class ManagerFactoryImpl implements ManagerFactory {

	private ProjetManager projetMgr;

	private TickteManager ticketMgr;

	@Override
	public void setProjetMgr(ProjetManager projetMgr) {
		this.projetMgr = projetMgr;
	}

	@Override
	public TickteManager getTicketMgr() {
		return ticketMgr;
	}

	@Override
	public void setTicketMgr(TickteManager ticketMgr) {
		this.ticketMgr = ticketMgr;
	}

	@Override
	public ProjetManager getProjetManager() {
		return projetMgr;
	}

	@Override
	public TickteManager getTicketManager() {
		return ticketMgr;
	}

}

package org.example.demo.ticket.business.factory.impl;

import javax.inject.Inject;
import javax.inject.Named;

import org.example.demo.ticket.business.factory.contract.ManagerFactory;
import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TicketManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("managerFactory")
public class ManagerFactoryImpl implements ManagerFactory {

	@Autowired
	private ProjetManager projetMgr;

	@Autowired
	private TicketManager ticketMgr;

	@Override
	public void setProjetMgr(ProjetManager projetMgr) {
		this.projetMgr = projetMgr;
	}

	@Override
	public TicketManager getTicketMgr() {
		return ticketMgr;
	}

	@Override
	public void setTicketMgr(TicketManager ticketMgr) {
		this.ticketMgr = ticketMgr;
	}

	@Override
	public ProjetManager getProjetManager() {
		return projetMgr;
	}

	@Override
	public TicketManager getTicketManager() {
		return ticketMgr;
	}

}

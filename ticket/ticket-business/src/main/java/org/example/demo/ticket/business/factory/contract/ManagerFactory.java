package org.example.demo.ticket.business.factory.contract;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TickteManager;

public interface ManagerFactory {

	TickteManager getTicketManager();

	ProjetManager getProjetManager();

	void setTicketMgr(TickteManager ticketMgr);

	TickteManager getTicketMgr();

	void setProjetMgr(ProjetManager projetMgr);

}

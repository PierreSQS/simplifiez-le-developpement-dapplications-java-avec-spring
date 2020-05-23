package org.example.demo.ticket.business.factory.contract;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TicketManager;

public interface ManagerFactory {

	TicketManager getTicketManager();

	ProjetManager getProjetManager();

	void setTicketMgr(TicketManager ticketMgr);

	TicketManager getTicketMgr();

	void setProjetMgr(ProjetManager projetMgr);

}

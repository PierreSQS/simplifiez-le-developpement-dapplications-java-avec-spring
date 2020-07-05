package org.example.demo.ticket.business.factory.contract;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.business.manager.contract.TicketManager;

public interface ManagerFactory {

	ProjetManager getProjetManager();

	void setTicketManager(TicketManager ticketMgr);

	TicketManager getTicketManager();

	void setProjetManager(ProjetManager projetMgr);

}

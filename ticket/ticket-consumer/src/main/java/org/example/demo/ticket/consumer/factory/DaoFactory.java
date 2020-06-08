package org.example.demo.ticket.consumer.factory;

import org.example.demo.ticket.consumer.dao.contrat.ProjetDao;
import org.example.demo.ticket.consumer.dao.contrat.TicketDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DaoFactory {
	
	@Autowired
	private TicketDao ticketDao;
	
	@Autowired
	private ProjetDao projetDao;

	public TicketDao getTicketDao() {
		return ticketDao;
	}

	public void setTicketDao(TicketDao ticketDao) {
		this.ticketDao = ticketDao;
	}

	public ProjetDao getProjetDao() {
		return projetDao;
	}

	public void setProjetDao(ProjetDao projetDao) {
		this.projetDao = projetDao;
	}
	

}

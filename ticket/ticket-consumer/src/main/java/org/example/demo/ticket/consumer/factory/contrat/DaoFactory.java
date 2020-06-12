package org.example.demo.ticket.consumer.factory.contrat;

import org.example.demo.ticket.consumer.dao.contrat.ProjetDao;
import org.example.demo.ticket.consumer.dao.contrat.TicketDao;

public interface DaoFactory {

	void setvTDao(TicketDao vTDao);

	TicketDao getvTDao();

	void setvPDao(ProjetDao vPDao);

	ProjetDao getvPDao();

}

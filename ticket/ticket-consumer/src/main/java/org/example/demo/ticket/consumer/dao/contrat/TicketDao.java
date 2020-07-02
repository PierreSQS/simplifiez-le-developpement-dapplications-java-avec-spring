package org.example.demo.ticket.consumer.dao.contrat;

import java.util.List;

import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

public interface TicketDao {

	Evolution getTicket(Long pNumero);

	List<Ticket> getListTicket();

	/**
	 * Recherche et renvoie les {@link Ticket} correspondant aux critères de
	 * recherche.
	 *
	 * @param pTicket critère de recherche Ticket
	 *                  {@link org.example.demo.ticket.model.recherche.ticket.RechercheTicket}
	 * @return List
	 */
	List<Ticket> getListTicket(RechercheTicket pTicket);

}

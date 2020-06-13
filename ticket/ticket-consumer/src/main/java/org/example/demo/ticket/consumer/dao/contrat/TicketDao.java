package org.example.demo.ticket.consumer.dao.contrat;

import java.util.List;

import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;

public interface TicketDao {

	List<Ticket> search(RechercheTicket pRechercheTicket);

}

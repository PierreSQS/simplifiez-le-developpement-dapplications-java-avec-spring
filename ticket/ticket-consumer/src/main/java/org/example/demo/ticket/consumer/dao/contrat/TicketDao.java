package org.example.demo.ticket.consumer.dao.contrat;

import org.example.demo.ticket.model.bean.ticket.Evolution;

public interface TicketDao {

	Evolution getTicket(Long pNumero);

}

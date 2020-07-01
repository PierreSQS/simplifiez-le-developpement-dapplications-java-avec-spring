package org.example.demo.ticket.consumer.rowmapper.ticket;

import java.sql.ResultSet;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.springframework.jdbc.core.RowMapper;

public class TicketRM {
	
	// RowMapper Ticket
	public final static RowMapper<Ticket> ROWMAPPERTICKET = (ResultSet rs, int rowNummer) -> {
		Ticket pTicket = new Evolution(rs.getLong("id"));
		pTicket.setTitre(rs.getString("titre"));
		pTicket.setDescription(rs.getString("description"));
		pTicket.setDate(rs.getDate("date"));

		// Projet du Ticket
		Projet vProj = new Projet();
		vProj.setId(rs.getInt("id"));
		vProj.setNom(rs.getString("nom"));
		pTicket.setProjet(vProj);
		return pTicket;
	};
}

package org.example.demo.ticket.consumer.rowmapper.ticket;

import java.sql.ResultSet;

import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.springframework.jdbc.core.RowMapper;

public class TicketStatutRM {
	
	// RowMapper TicketStatut
	public final static RowMapper<TicketStatut> ROWMAPPERTICKETSTATUT = (ResultSet rs, int rowNummer) -> {
		TicketStatut pTicketStatut = new TicketStatut(rs.getInt("id"));
		pTicketStatut.setLibelle(rs.getString("libelle"));
		return pTicketStatut;
	};
}

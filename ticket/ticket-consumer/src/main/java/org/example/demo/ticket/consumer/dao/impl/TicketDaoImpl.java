package org.example.demo.ticket.consumer.dao.impl;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.dao.AbstractDao;
import org.example.demo.ticket.consumer.dao.contrat.TicketDao;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class TicketDaoImpl extends AbstractDao implements TicketDao {
	private final static String NOTICKETMSG = "Ticket non-existant";
	
	// Logger de la classe
	private final static Log LOGGER = LogFactory.getLog(TicketDao.class);
	
	// SQL-Statement
	private final static String vSELECT_ALL_TICKETS = 
			"SELECT t.numero, t.titre, t.description, t.date, p.id, p.nom \r\n"+ 
			"FROM public.ticket t, public.projet p ";

	@Override
	public Evolution getTicket(Long pNumero) {
		// StringBuilder pour gérer le paramètre pId null
		StringBuilder vSQLBuilder = new StringBuilder(vSELECT_ALL_TICKETS);				
		vSQLBuilder.append("WHERE t.projet_id = p.id AND t.numero = :numero");
		

		// Stockage des paramètres SQL
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("numero", pNumero);
		
		// RowMapper Ticket
		RowMapper<Ticket> rowMapper = (ResultSet rs, int rowNummer) -> {
			Ticket pTicket = new Evolution(pNumero);
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
		
		// Execution de la commande SQL
		List<Ticket> vTickets = getvNamedJdbcTemplate().query(vSQLBuilder.toString(), vParams, rowMapper);

		// retour du ticket
		Optional<Ticket> optProjet = vTickets.stream().findFirst();
		if (optProjet.isPresent()) {
			return (Evolution) optProjet.get();
		}
		
		Ticket pTicket = new Evolution();
		pTicket.setDescription(NOTICKETMSG);
		
		LOGGER.info(NOTICKETMSG);
		return (Evolution) pTicket;
	}

}

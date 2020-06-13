package org.example.demo.ticket.consumer.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.dao.contrat.TicketDao;
import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

@Component("ticketDao")
public class TicketDaoImpl extends AbstractDao implements TicketDao {
	   /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(TicketDaoImpl.class);

	@Override
	public List<Ticket> search(RechercheTicket pRechercheTicket) {

		final String vSQL= "SELECT * FROM public.ticket WHERE 1=1";
		StringBuilder vSQLBuilder = new StringBuilder(vSQL);

		LOGGER.info("################################ the Select- Command: "+vSQL);		
        if (pRechercheTicket != null) {
        	Integer auteurId = pRechercheTicket.getAuteurId();
        	Integer projetId = pRechercheTicket.getProjetId();
        	
            if (auteurId != null) {
            	vSQLBuilder.append(" AND auteur_id = "+auteurId.toString());
            }
            if (projetId != null) {
            	vSQLBuilder.append(" AND projet_id = "+projetId.toString());
            }
        }
        
        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDatasource());

        RowMapper<Ticket> vRowMapper = new RowMapper<Ticket>() {
            public Ticket mapRow(ResultSet pRS, int pRowNum) throws SQLException {
                Ticket vTicket = new Evolution(pRS.getLong("numero"));
                vTicket.setTitre(pRS.getString("Titre"));
                vTicket.setDate(pRS.getDate("date"));
                vTicket.setDescription(pRS.getString("description"));
 //               vTicket.setStatut(pRS.getInt("statut_actuel_id"));
                return vTicket;
            }
        };


        List<Ticket> ticketList = vJdbcTemplate.query(vSQLBuilder.toString(), vRowMapper);
        return ticketList;
}}

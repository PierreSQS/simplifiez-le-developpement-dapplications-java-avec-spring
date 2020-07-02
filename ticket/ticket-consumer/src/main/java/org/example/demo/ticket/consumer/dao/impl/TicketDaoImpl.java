package org.example.demo.ticket.consumer.dao.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.dao.AbstractDao;
import org.example.demo.ticket.consumer.dao.contrat.TicketDao;
import org.example.demo.ticket.consumer.rowmapper.ticket.TicketRM;
import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class TicketDaoImpl extends AbstractDao implements TicketDao {
	private final static String NOTICKETMSG = "Ticket non-existant";

	// Logger de la classe
	private final static Log LOGGER = LogFactory.getLog(TicketDao.class);

	// SQL-Statement
	private final static String vSELECT_ALL_TICKETS = "SELECT t.numero, t.titre, t.description, t.date, p.id, p.nom\r\n"
			+ "FROM public.ticket t, public.projet p " + "WHERE t.projet_id = p.id ";

	@Override
	public Evolution getTicket(Long pNumero) {
		// StringBuilder pour gérer le paramètre pId null
		StringBuilder vSQLBuilder = new StringBuilder(vSELECT_ALL_TICKETS);
		vSQLBuilder.append(" AND t.numero = :numero");

		// Stockage des paramètres SQL
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("numero", pNumero);

		// Execution de la commande SQL
		List<Ticket> vTickets = getvNamedJdbcTemplate()
				.query(vSQLBuilder.toString(), vParams, TicketRM.ROWMAPPERTICKET);

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

	@Override
	public List<Ticket> getListTicket() {

		return getvJdbcTemplate()
				.query(vSELECT_ALL_TICKETS, TicketRM.ROWMAPPERTICKET);
	}

	/**
	 * Recherche et renvoie les {@link Ticket} correspondant aux critères de
	 * recherche.
	 *
	 * @param pTicket critère de recherche Ticket
	 *                  {@link org.example.demo.ticket.model.recherche.ticket.RechercheTicket}
	 * @return List
	 */
	
	@Override
	public List<Ticket> getListTicket(RechercheTicket pTicket) {
		// StringBuilder pour gérer le paramètre pId null
		StringBuilder vSQLBuilder = new StringBuilder(vSELECT_ALL_TICKETS);

		if (pTicket != null) {
			if (pTicket.getProjetId() != null) {
				vSQLBuilder.append(" AND t.projet_id = :projet_id");
			}

			if (pTicket.getAuteurId() != null) {
				vSQLBuilder.append(" AND t.auteur_id = :auteur_id");
			}

		}

		// Stockage des paramètres SQL
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("projet_id", pTicket.getProjetId());
		vParams.addValue("auteur_id", pTicket.getAuteurId());

		// Lancer la requête
		List<Ticket> vTicketListe = getvNamedJdbcTemplate()
				.query(vSQLBuilder.toString(), vParams, TicketRM.ROWMAPPERTICKET);

		return vTicketListe;

	}

}

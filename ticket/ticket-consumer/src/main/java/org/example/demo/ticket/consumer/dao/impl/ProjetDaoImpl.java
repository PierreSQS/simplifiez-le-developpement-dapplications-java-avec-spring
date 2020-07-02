package org.example.demo.ticket.consumer.dao.impl;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.dao.AbstractDao;
import org.example.demo.ticket.consumer.dao.contrat.ProjetDao;
import org.example.demo.ticket.consumer.rowmapper.projet.ProjetRM;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

@Component
public class ProjetDaoImpl extends AbstractDao implements ProjetDao {
	
	private final static String noProjMessage = "Projet non-existant";
	// Logger de la classe
	private final static Log LOGGER = LogFactory.getLog(ProjetDaoImpl.class);
	
	// SQL-Statement
	private final static String vSELECT_ALL_PROJETS = 
			"SELECT p.id, p.nom, p.date_creation, p.cloture, p.responsable_id, u.id, u.nom as \"responsable\"\r\n" + 
            "FROM public.projet p, public.utilisateur u\r\n" +
            "WHERE p.responsable_id = u.id";

	
	@Override
	public Projet getProjet(Integer pId) {
		
		// StringBuilder pour gérer le paramètre pId null
		StringBuilder vSQLBuilder = new StringBuilder(vSELECT_ALL_PROJETS);				
		vSQLBuilder.append(" AND p.id = :id");
		

		// Stockage des paramètres SQL
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", pId);
		
		// Execution de la commande SQL
		List<Projet> vProjets = getvNamedJdbcTemplate()
				.query(vSQLBuilder.toString(), vParams, ProjetRM.ROWMAPPERPROJET);

		// retour du projet
		Optional<Projet> optProjet = vProjets.stream().findFirst();
		if (optProjet.isPresent()) {
			return optProjet.get();
		}
		
		Projet pProj = new Projet();
		pProj.setNom(noProjMessage);
		
		LOGGER.info(noProjMessage);
		return pProj;		
	
	}

	@Override
	public List<Projet> getListProjet() {

		List<Projet> vListProjet = getvJdbcTemplate()
				.query(vSELECT_ALL_PROJETS, ProjetRM.ROWMAPPERPROJET);
		return vListProjet;
	}

}

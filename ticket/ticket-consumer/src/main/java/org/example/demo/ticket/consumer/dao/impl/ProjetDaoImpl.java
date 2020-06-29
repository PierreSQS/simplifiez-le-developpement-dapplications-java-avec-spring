package org.example.demo.ticket.consumer.dao.impl;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.consumer.AbstractDao;
import org.example.demo.ticket.consumer.dao.contrat.ProjetDao;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;
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
		
		// RowMapper
		RowMapper<Projet> rowMapper = (ResultSet rs, int rowNummer) -> {
			Projet pProj = new Projet(rs.getInt("id"));
			pProj.setNom(rs.getString("nom"));
			pProj.setDateCreation(rs.getDate("date_creation"));
			pProj.setCloture(rs.getBoolean("cloture"));
			
			// user pour le RowMapper projets
			Utilisateur user = new Utilisateur();			
			user.setId(rs.getInt("responsable_id"));
			user.setNom(rs.getString("responsable"));
			pProj.setResponsable(user);
			return pProj;
		};
		
		// Execution de la commande SQL
		List<Projet> vProjets = getvNamedJdbcTemplate().query(vSQLBuilder.toString(), vParams, rowMapper);

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

		RowMapper<Projet> vRowMapper = (ResultSet rs, int rowNum) -> {

			Projet vProj = new Projet(rs.getInt("id"));
			vProj.setNom(rs.getString("nom"));
			vProj.setDateCreation(rs.getDate("date_creation"));
			
			// user pour le RowMapper projets
			Utilisateur user = new Utilisateur();
			
			vProj.setCloture(rs.getBoolean("cloture"));
			user.setId(rs.getInt("responsable_id"));
			user.setNom(rs.getString("responsable"));
			vProj.setResponsable(user);
			return vProj;

		};

		List<Projet> vListProjet = getvJdbcTemplate().query(vSELECT_ALL_PROJETS, vRowMapper);
		return vListProjet;
	}

}

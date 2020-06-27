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
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ProjetDaoImpl extends AbstractDao implements ProjetDao {
	
	private final static String noProjMessage = "Projet non-existant";
	// Logger de la classe
	private final static Log LOGGER = LogFactory.getLog(ProjetDaoImpl.class);
	
	@Override
	public Projet getProjet(Integer pId) {
		
		// SQL-Statement
		final String vSQL = "SELECT * FROM public.projet WHERE 1=1";
		
		
		// StringBuilder pour gérer le paramètre pId null
		StringBuilder vSQLBuilder = new StringBuilder(vSQL);				
		vSQLBuilder.append(" AND id = :id ");
		

		// Stockage des paramètres SQL
		MapSqlParameterSource vParams = new MapSqlParameterSource();
		vParams.addValue("id", pId);
		
		// user pour le RowMapper		
		Utilisateur user = new Utilisateur();
		
		// RowMapper
		RowMapper<Projet> rowMapper = (ResultSet rs, int rowNummer) -> {
			Projet pProj = new Projet(rs.getInt("id"));
			pProj.setNom(rs.getString("nom"));
			pProj.setDateCreation(rs.getDate("date_creation"));
			pProj.setCloture(rs.getBoolean("cloture"));
			user.setId(rs.getInt("responsable_id"));
			pProj.setResponsable(user);
			return pProj;
		};
		
		// NamedParameter
		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		
		// Execution de la commande SQL
		List<Projet> vProjets = vJdbcTemplate.query(vSQLBuilder.toString(), vParams, rowMapper);

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

}

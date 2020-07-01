package org.example.demo.ticket.consumer.rowmapper.projet;

import java.sql.ResultSet;

import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

public class ProjetRM {
	// RowMapper
	public final static RowMapper<Projet> ROWMAPPERPROJET = (ResultSet rs, int rowNummer) -> {
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
}

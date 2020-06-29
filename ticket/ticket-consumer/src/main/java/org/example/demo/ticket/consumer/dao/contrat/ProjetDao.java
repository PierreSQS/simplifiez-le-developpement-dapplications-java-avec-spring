package org.example.demo.ticket.consumer.dao.contrat;

import java.util.List;

import org.example.demo.ticket.model.bean.projet.Projet;

public interface ProjetDao {

	Projet getProjet(Integer pId);

	List<Projet> getListProjet();

}

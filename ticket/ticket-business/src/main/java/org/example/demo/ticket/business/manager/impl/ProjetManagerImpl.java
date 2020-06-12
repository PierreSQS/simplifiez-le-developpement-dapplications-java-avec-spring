package org.example.demo.ticket.business.manager.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.springframework.stereotype.Component;

@Component("projetManager")
public class ProjetManagerImpl extends AbstractManager implements ProjetManager {


    /**
     * Renvoie le projet demandé
     *
     * @param pId l'identifiant du projet
     * @return Le {@link Projet}
     * @throws NotFoundException Si le projet n'est pas trouvé
     */
    @Override
	public Projet getProjet(Integer pId) throws NotFoundException {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        if (pId < 1) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        }
        Projet vProjet = new Projet(pId);
        vProjet.setNom("Projet n°" + pId);
        return vProjet;
    }


    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    @Override
	public List<Projet> getListProjet() {
        
        List<Projet> vList = getDaoFactory().getvPDao().getListProjets();
        return vList;
    }
}

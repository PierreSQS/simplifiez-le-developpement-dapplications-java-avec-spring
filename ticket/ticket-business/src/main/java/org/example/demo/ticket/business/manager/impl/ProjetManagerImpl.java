package org.example.demo.ticket.business.manager.impl;

import java.util.List;

import org.example.demo.ticket.business.manager.AbstractManager;
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
        if (pId < 1) {
            throw new NotFoundException("Projet non trouvé : ID=" + pId);
        }
        Projet vProjet = getDaofact().getProjetDao().getProjet(pId);
        return vProjet;
    }


    /**
     * Renvoie la liste des {@link Projet}
     *
     * @return List
     */
    @Override
	public List<Projet> getListProjet() {
  
        List<Projet> vList = getDaofact().getProjetDao().getListProjet();
        for (int vI = 0; vI < 9; vI++) {
            Projet vProjet = new Projet(vI);
            vProjet.setNom("Projet n°" + vI);
            vList.add(vProjet);
        }
        return vList;
    }
}

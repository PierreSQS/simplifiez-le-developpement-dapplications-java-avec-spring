package org.example.demo.ticket.webapp.rest.resource.projet;

import java.util.List;

import org.example.demo.ticket.business.manager.contract.ProjetManager;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.webapp.rest.resource.AbstractResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * Ressource REST pour les {@link Projet}.
 *
 * @author lgu
 */
@Controller
@RequestMapping("/projets")
public class ProjetResource extends AbstractResource{

    /**
     * Renvoie le {@link Projet} d'identifiant {@code pId}
     *
     * @param pId identifiant du {@link Projet}
     * @return Le {@link Projet}
     * @throws NotFoundException Si le {@link Projet} n'a pas été trouvé
     * 
     * Attention! l'appel qui déclenche la méthode ci-dessous est
     * http://localhost:8080/ticket-webapp/projets/4 et non 
     * http://localhost:8080/ticket-webapp/projets/?id=4. 
     * Cet appel déclenche la méthode ci-dessus!!!! 
     */
    @GetMapping("{id}")
    public Projet get(@PathVariable("id") Integer pId) throws NotFoundException {
        ProjetManager vProjetManager = getManagerFactory().getProjetManager();
        Projet vProjet = vProjetManager.getProjet(pId);
        return vProjet;
    }


    /**v+
     * Renvoie tous les {@link Projet}
     *
     * @return List
     */
    @GetMapping
    public List<Projet> get() {
        ProjetManager vProjetManager = getManagerFactory().getProjetManager();
        List<Projet> vListProjet = vProjetManager.getListProjet();
        return vListProjet;
    }
}

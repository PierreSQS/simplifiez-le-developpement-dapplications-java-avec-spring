package org.example.demo.ticket.webapp.rest.resource.ticket;

import java.util.List;

import org.example.demo.ticket.business.manager.contract.TicketManager;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.example.demo.ticket.webapp.rest.resource.AbstractResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Ressource REST pour les {@link Ticket}.
 *
 * @author lgu
 */

@Controller
@RequestMapping(path = "/tickets")
public class TicketResource extends AbstractResource {


    /**
     * Renvoie le {@link Ticket} de numéro {@code pNumero}
     *
     * @param pNumero numéro du {@link Ticket}
     * @return Le {@link Ticket}
     * @throws NotFoundException Si le {@link Ticket} n'a pas été trouvé
     */
    @GetMapping("{numero}")
    public Ticket get(@PathVariable("numero") Long pNumero) throws NotFoundException {
        TicketManager vTicketManager = getManagerFactory().getTicketManager();
        Ticket vTicket = vTicketManager.getTicket(pNumero);
        return vTicket;
    }

    /**
     * Recherche et renvoie les {@link Ticket} correspondant aux critères.
     *
     * @param pProjetId identifiant du {@link org.example.demo.ticket.model.bean.projet.Projet}
     * @return List
     */
    @GetMapping("search")
    public List<Ticket> search(@RequestParam("projetId") Integer pProjetId, @RequestParam("auteurId") Integer pAuteurId) {
        TicketManager vTicketManager = getManagerFactory().getTicketManager();
        List<Ticket> vList = vTicketManager.getListTicket(new RechercheTicket()
                                                              .setProjetId(pProjetId)
                                                              .setAuteurId(pAuteurId));
        return vList;
    }
}

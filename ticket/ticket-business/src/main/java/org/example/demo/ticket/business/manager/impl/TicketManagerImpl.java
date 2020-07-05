package org.example.demo.ticket.business.manager.impl;

import java.util.List;

import org.example.demo.ticket.business.manager.AbstractManager;
import org.example.demo.ticket.business.manager.contract.TicketManager;
import org.example.demo.ticket.model.bean.ticket.Evolution;
import org.example.demo.ticket.model.bean.ticket.Ticket;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.exception.NotFoundException;
import org.example.demo.ticket.model.recherche.ticket.RechercheTicket;
import org.springframework.stereotype.Component;

@Component("ticketManager")
public class TicketManagerImpl extends AbstractManager implements TicketManager {

	/**
	 * Cherche et renvoie le {@link Ticket} numéro {@code pNumero}
	 *
	 * @param pNumero le numéro du Ticket
	 * @return Le {@link Ticket}
	 * @throws NotFoundException Si le Ticket n'est pas trouvé
	 */
	@Override
	public Ticket getTicket(Long pNumero) throws NotFoundException {
		
		//TODO Ameliorer le code
		
		if (pNumero < 1L) {
			throw new NotFoundException("Ticket non trouvé : numero=" + pNumero);
		}
		Evolution vEvolution = getDaofact().getTicketDao().getTicket(pNumero);
		// n'est pas encore pris en compte dans l'implementation actuelle
		vEvolution.setPriorite(10);
		return vEvolution;
	}

	/**
	 * Renvoie la liste des {@link Ticket} correspondants aux critères de recherche.
	 *
	 * @param pRechercheTicket -
	 * @return List
	 */
	@Override
	public List<Ticket> getListTicket(RechercheTicket pRechercheTicket) {

		List<Ticket> vList = getDaofact().getTicketDao().getListTicket(pRechercheTicket);
//		if (pRechercheTicket.getProjetId() != null) {
//			Projet vProjet = new Projet(pRechercheTicket.getProjetId());
//			for (int vI = 0; vI < 4; vI++) {
//				Ticket vTicket = new Bug((long) pRechercheTicket.getProjetId() * 10 + vI);
//				vTicket.setProjet(vProjet);
//				vList.add(vTicket);
//			}
//		} else {
//			for (int vI = 0; vI < 9; vI++) {
//				Ticket vTicket = new Evolution((long) vI);
//				vList.add(vTicket);
//			}
//		}
		return vList;
	}

	/**
	 * Renvoie le nombre de {@link Ticket} correspondants aux critères de recherche.
	 *
	 * @param pRechercheTicket -
	 * @return int
	 */
	@Override
	public int getCountTicket(RechercheTicket pRechercheTicket) {
		// Je n'ai pas encore codé la DAO
		// Je mets juste un code temporaire pour commencer le cours...
		return 42;
	}

	/**
	 * Renvoie la liste des {@link TicketStatut} Statuts de tickets.
	 *
	 * @param pRechercheTicket -
	 * @return List
	 */
	@Override
	public List<TicketStatut> getListTicketStatut() {
		
		return getDaofact().getTicketDao().getTicketStatuts();
	}

}

package org.example.demo.ticket.consumer.factory.impl;

import org.example.demo.ticket.consumer.dao.contrat.ProjetDao;
import org.example.demo.ticket.consumer.dao.contrat.TicketDao;
import org.example.demo.ticket.consumer.factory.contrat.DaoFactory;
import org.springframework.stereotype.Component;

@Component("daoFactory")
public class DaoFactoryImpl implements DaoFactory {
	
	private ProjetDao vPDao;
	
	private TicketDao vTDao;

}

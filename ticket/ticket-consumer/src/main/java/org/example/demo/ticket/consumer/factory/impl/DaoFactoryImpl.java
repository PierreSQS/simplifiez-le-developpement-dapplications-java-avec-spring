package org.example.demo.ticket.consumer.factory.impl;

import org.example.demo.ticket.consumer.dao.contrat.ProjetDao;
import org.example.demo.ticket.consumer.dao.contrat.TicketDao;
import org.example.demo.ticket.consumer.factory.contrat.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("daoFactory")
public class DaoFactoryImpl implements DaoFactory {
	
	@Autowired
	private ProjetDao vPDao;
	
	@Autowired
	private TicketDao vTDao;

	@Override
	public ProjetDao getvPDao() {
		return vPDao;
	}

	@Override
	public void setvPDao(ProjetDao vPDao) {
		this.vPDao = vPDao;
	}

	@Override
	public TicketDao getvTDao() {
		return vTDao;
	}

	@Override
	public void setvTDao(TicketDao vTDao) {
		this.vTDao = vTDao;
	}
	
	

}

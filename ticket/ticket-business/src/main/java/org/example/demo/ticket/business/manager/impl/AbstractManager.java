package org.example.demo.ticket.business.manager.impl;

import org.example.demo.ticket.consumer.factory.contrat.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractManager {
	
	@Autowired
	private DaoFactory daoFactory;

	protected DaoFactory getDaoFactory() {
		return daoFactory;
	}

	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
	

}

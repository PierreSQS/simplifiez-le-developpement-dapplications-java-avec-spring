package org.example.demo.ticket.business.manager;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractManager {
	
	@Autowired
	private DataSource dataSourceTicket;

	protected DataSource getDataSource() {
		return dataSourceTicket;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSourceTicket = dataSource;
	}
	

}

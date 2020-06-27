package org.example.demo.ticket.consumer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDao {
	
	@Autowired
	private DataSource dataSourceTicket;

	protected DataSource getDataSource() {
		return dataSourceTicket;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSourceTicket = dataSource;
	}

}

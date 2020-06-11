package org.example.demo.ticket.consumer.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public abstract class AbstractDao {
	
	@Autowired
	@Qualifier("dataSourceTicket")
	private DataSource datasource;

	protected DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

}

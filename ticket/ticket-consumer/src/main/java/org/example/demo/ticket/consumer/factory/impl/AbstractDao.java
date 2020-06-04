package org.example.demo.ticket.consumer.factory.impl;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;

public abstract class AbstractDao {
	
	@Inject
	@Named("dataSourceTicket")
	private DataSource datasource;

	protected DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

}

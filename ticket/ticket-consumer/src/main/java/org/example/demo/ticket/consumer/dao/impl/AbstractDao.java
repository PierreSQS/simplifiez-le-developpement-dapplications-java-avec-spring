package org.example.demo.ticket.consumer.factory.impl;

import javax.sql.DataSource;

public abstract class AbstractDao {
	
	// A ce niveau la DataSource n'est pas encore assignée
	// bien qu'elle soit déjà instanciée. Voir webappContext.xml
	// Donc les annotations ne sont pas évaluées
	//@Inject
	//@Named("dataSourceTicket")
	private DataSource datasource;

	protected DataSource getDatasource() {
		return datasource;
	}

	public void setDatasource(DataSource datasource) {
		this.datasource = datasource;
	}

}

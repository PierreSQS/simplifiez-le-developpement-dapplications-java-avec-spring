package org.example.demo.ticket.consumer;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class AbstractDao {
	
	@Autowired
	private DataSource dataSourceTicket;
	
	@Autowired
	private JdbcTemplate vJdbcTemplate;	


	protected DataSource getDataSource() {
		return dataSourceTicket;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSourceTicket = dataSource;
	}

	protected JdbcTemplate getvJdbcTemplate() {
		return vJdbcTemplate;
	}

	protected void setvJdbcTemplate(JdbcTemplate vJdbcTemplate) {
		this.vJdbcTemplate = vJdbcTemplate;
	}

}

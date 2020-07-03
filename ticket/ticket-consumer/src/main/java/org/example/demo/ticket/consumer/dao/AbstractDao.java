package org.example.demo.ticket.consumer.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public abstract class AbstractDao {
	
	@Autowired
	private JdbcTemplate vJdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate vNamedJdbcTemplate;


	protected JdbcTemplate getvJdbcTemplate() {
		return vJdbcTemplate;
	}

	protected void setvJdbcTemplate(JdbcTemplate vJdbcTemplate) {
		this.vJdbcTemplate = vJdbcTemplate;
	}

	protected NamedParameterJdbcTemplate getvNamedJdbcTemplate() {
		return vNamedJdbcTemplate;
	}

	protected void setvNamedJdbcTemplate(NamedParameterJdbcTemplate vNamedJdbcTemplate) {
		this.vNamedJdbcTemplate = vNamedJdbcTemplate;
	}

}

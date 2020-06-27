package org.example.demo.ticket.business.manager;

import org.example.demo.ticket.consumer.factory.DaoFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractManager {

	@Autowired
	private DaoFactory daofact;

	protected DaoFactory getDaofact() {
		return daofact;
	}

	public void setDaofact(DaoFactory daofact) {
		this.daofact = daofact;
	}

}

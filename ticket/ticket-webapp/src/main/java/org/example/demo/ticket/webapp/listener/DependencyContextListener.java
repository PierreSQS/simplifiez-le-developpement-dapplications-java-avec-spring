package org.example.demo.ticket.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.example.demo.ticket.business.factory.ManagerFactory;
import org.example.demo.ticket.webapp.rest.resource.AbstractResource;

public class DependencyContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sCtxt) {
		ManagerFactory vMgrFactory = new ManagerFactory();
		AbstractResource.setMgrFactory(vMgrFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sCtxt) {
		// TODO Auto-generated method stub

	}

}

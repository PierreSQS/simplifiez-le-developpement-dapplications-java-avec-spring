package org.example.demo.ticket.webapp.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.example.demo.ticket.business.factory.ManagerFactory;
import org.example.demo.ticket.business.manager.impl.ProjetManagerImpl;
import org.example.demo.ticket.business.manager.impl.TicketManagerImpl;
import org.example.demo.ticket.webapp.rest.resource.AbstractResource;

@WebListener
public class DependencyContextListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sCtxt) {
		ManagerFactory vMgrFactory = new ManagerFactory();

		vMgrFactory.setTicketMgr(new TicketManagerImpl());
		vMgrFactory.setProjetMgr(new ProjetManagerImpl());

		AbstractResource.setMgrFactory(vMgrFactory);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sCtxt) {
		// TODO Auto-generated method stub

	}

}

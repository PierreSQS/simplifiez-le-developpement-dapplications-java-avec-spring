package org.example.demo.ticket.batch;


import java.util.Arrays;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.batch.configuration.SpringConfiguration;
import org.example.demo.ticket.business.factory.contract.ManagerFactory;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Classe Principale de lancement des Batches.
 *
 * @author lgu
 */
public class Main {

    /** Logger pour la classe */
    private static final Log LOGGER = LogFactory.getLog(Main.class);


    /**
     * The entry point of application.
     *
     * @param pArgs the input arguments
     * @throws TechnicalException sur erreur technique
     */
    public static void main(String[] pArgs) throws TechnicalException {
        
    	AnnotationConfigApplicationContext  appCtx = 
    			new AnnotationConfigApplicationContext();
    	appCtx.register(SpringConfiguration.class);
    	appCtx.refresh();    	
    	
    	
    	try {
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }
            
        	ManagerFactory vMgrFactory = appCtx.getBean("managerFactory", ManagerFactory.class);
        	
        	//Arrays.asList(appCtx.getBeanDefinitionNames()).stream().forEach(name ->{LOGGER.info(name);});
        	Arrays.asList(appCtx.getBeanDefinitionNames()).stream().forEach(LOGGER::info);


            String vTraitementId = pArgs[0];
            if ("ExportTicketStatus".equals(vTraitementId)) {
                LOGGER.info("Execution du traitement : ExportTicketStatus");
                // ...
            } else {
                throw new TechnicalException("Traitement inconnu : " + vTraitementId);
            }
        } catch (Throwable vThrowable) {
            LOGGER.error(vThrowable);
            System.exit(1);
        } finally {
			appCtx.close();
		}
    }
}

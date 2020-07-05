package org.example.demo.ticket.batch;


import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.demo.ticket.business.factory.contract.ManagerFactory;
import org.example.demo.ticket.model.bean.projet.Projet;
import org.example.demo.ticket.model.bean.ticket.TicketStatut;
import org.example.demo.ticket.model.exception.TechnicalException;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;


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
        
    	ConfigurableApplicationContext  appCtx = 
    			new ClassPathXmlApplicationContext("classpath:/bootstrapContext.xml");    	
    	
    	
    	try {
            if (pArgs.length < 1) {
                throw new TechnicalException("Veuillez préciser le traitement à effectuer !");
            }
            
        	ManagerFactory vMgrFactory = appCtx.getBean("managerFactory", ManagerFactory.class);
        	
        	Projet projet = vMgrFactory.getProjetManager().getProjet(2);
        	LOGGER.info("======= The Projet 2 = "+ projet);
        	
        	        	
            int beansAmount = appCtx.getBeanDefinitionCount();
        	LOGGER.info("======= The Amount of created beans in the App Context: "+beansAmount+" ====");

            LOGGER.info("======= The created beans... ====");
        	Arrays.asList(appCtx.getBeanDefinitionNames()).stream().forEach(LOGGER::info);
        	
        	Resource vRes = appCtx.getBean("resourceTicket", FileSystemResource.class);
        	
        	List<TicketStatut> ticketStatuts = vMgrFactory.getTicketManager().getListTicketStatut();
        	
        	List<String> listeStatus = ticketStatuts.stream().map(TicketStatut::toString)
        			                                         .collect(Collectors.toList());
        	
            String vTraitementId = pArgs[0];
            if ("ExportTicketStatus".equals(vTraitementId)) {
                LOGGER.info("Execution du traitement : ExportTicketStatus");
               	writeStatut(vRes, listeStatus);
                LOGGER.info("Execution du traitement terminé avec succès!!!");
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
    

	private static void writeStatut(Resource vRes, List<String> lines) throws IOException {
//		Files.write(Paths.get(vRes.getFilename()).toAbsolutePath(), lines, StandardCharsets.UTF_8);
		Files.write(Paths.get(vRes.getURI()), lines, StandardCharsets.UTF_8);
		LOGGER.info("###### URI: "+vRes.getURI().toString());
		LOGGER.info("###### File-Path: "+Paths.get(vRes.getFilename()).toAbsolutePath().toString());		
	}    
    

}

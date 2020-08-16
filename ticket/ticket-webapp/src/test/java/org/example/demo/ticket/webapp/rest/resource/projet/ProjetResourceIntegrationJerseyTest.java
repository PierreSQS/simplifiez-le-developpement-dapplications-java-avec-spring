package org.example.demo.ticket.webapp.rest.resource.projet;

import org.example.demo.ticket.webapp.configuration.SpringTestConfiguration;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.junit.jupiter.web.SpringJUnitWebConfig;



@SpringJUnitWebConfig(classes = SpringTestConfiguration.class)
public class ProjetResourceIntegrationJerseyTest {

	@Test
	@Disabled("Not Ready yet")
	public void testgetProjets() throws Exception {
		
	}
	
	
	@Test
	public void givenGetAllProjects_whenCorrectRequest_thenResponseCodeSuccess() {
		
	}
}

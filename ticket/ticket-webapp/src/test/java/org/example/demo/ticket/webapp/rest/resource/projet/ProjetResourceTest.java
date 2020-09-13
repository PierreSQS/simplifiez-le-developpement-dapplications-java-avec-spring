package org.example.demo.ticket.webapp.rest.resource.projet;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;



@WebMvcTest(ProjetResource.class)
public class ProjetResourceTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Test
	@Disabled("Not Ready yet")
	public void testgetProjets() throws Exception {
		this.mockMvc.perform(get("/ticket-webapp/projets").accept(MediaType.APPLICATION_JSON))
							.andExpect(status().isOk())
							.andDo(print())
							.andExpect(content().contentType("application/json"))
							.andExpect(jsonPath("$.name").value("Lee"));
	}
}

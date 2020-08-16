package org.example.demo.ticket.webapp.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Transformation jersey-rest -> SpringBoot
 *
 * @author Pierrot Mongonnam
 */
@SpringBootApplication
public class TicketApplication {
	
	public static void main(String...args) {
		SpringApplication.run(TicketApplication.class, args);
	}
}

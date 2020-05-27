package org.example.demo.ticket.webapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.example.demo.ticket")
// OUBLIE IMPORT DU FICHIER applicationContext.xml de ticket-webapp
public class SpringConfiguration {

}

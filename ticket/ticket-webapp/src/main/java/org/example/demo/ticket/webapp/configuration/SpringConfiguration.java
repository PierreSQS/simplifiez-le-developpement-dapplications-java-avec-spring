package org.example.demo.ticket.webapp.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

//@Configuration
@ComponentScan("org.example.demo.ticket")
@ImportResource("classpath:/applicationContext.xml")
public class SpringConfiguration {

}

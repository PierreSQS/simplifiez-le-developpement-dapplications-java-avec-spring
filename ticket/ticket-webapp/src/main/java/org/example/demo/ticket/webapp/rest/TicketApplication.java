package org.example.demo.ticket.webapp.rest;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource; ;


/**
 * Transformation jersey-rest et JDBC -> SpringBoot et JDBC
 *
 * @author Pierrot Mongonnam
 */
@SpringBootApplication(scanBasePackages = {"org.example.demo.ticket.consumer", 
										   "org.example.demo.ticket.business"})
@EntityScan(basePackages = "org.example.demo.ticket.model" )
//@ImportResource(locations = "classpath:/org/example/demo/ticket/webapp/webappContext.xml")
//@Import(SpringConfiguration.class)
public class TicketApplication {
	
	@Autowired
	private DataSource ds;
	
	public static void main(String...args) {
		SpringApplication.run(TicketApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

			
			System.out.println("Let's count the amount of beans provided by Spring Boot:");
			System.out.println(ctx.getBeanDefinitionCount());

			System.out.println("Let's inspect the beans provided by Spring Boot:");

			String[] beanNames = ctx.getBeanDefinitionNames();
			Arrays.asList(beanNames).stream().sorted().forEach(System.out::println);
			
			System.out.printf("%nthe Datasource : %s%n%n", ds.getClass().getName());
		};
	}
}

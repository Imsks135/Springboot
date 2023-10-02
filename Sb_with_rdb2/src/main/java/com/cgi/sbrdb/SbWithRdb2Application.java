package com.cgi.sbrdb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SbWithRdb2Application {

	private static final Logger log = LoggerFactory.getLogger(SbWithRdb2Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(SbWithRdb2Application.class, args);
	}
	 @Bean
	  public CommandLineRunner demo(ProductRepository repository) {
	    return (args) -> {
	      // save a few products
	      repository.save(new ProductDAO("Laptop", 66666.99));
	      repository.save(new ProductDAO("Phone", 23999.99));
	      repository.save(new ProductDAO("Tablet", 21999.99));
	      repository.save(new ProductDAO("Headphones", 3599.99));
	      repository.save(new ProductDAO("Monitor", 25499.99)); 

	      // fetch all products
	      log.info("Products found with findAll():");
	      log.info("-------------------------------");
	      for (ProductDAO product : repository.findAll()) {
	        log.info(product.toString());
	      }
	      log.info("");

	      // fetch an individual product by ID
	      ProductDAO product = repository.findById(3L);
	      log.info("Product found with findById(3L):");
	      log.info("--------------------------------");
	      log.info(product.toString());
	      log.info("");

	      // fetch products by name
	      log.info("Products found with findByName('Tablet'):");
	      log.info("--------------------------------------------");
	      repository.findByName("Tablet").forEach(Tablet -> {
	        log.info(Tablet.toString());
	      });
	      log.info("");
	    };
	  }

}

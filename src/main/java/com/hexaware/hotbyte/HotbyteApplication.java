package com.hexaware.hotbyte;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HotbyteApplication {
	private static final Logger log = LoggerFactory.getLogger(HotbyteApplication.class);
	public static void main(String[] args) {
		
		log.info("Starting Hotbyte Application");

		SpringApplication.run(HotbyteApplication.class, args);
		
		log.info("Hotbyte application terminated");
		
	}

}

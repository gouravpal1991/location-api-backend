package com.learning.locationapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class LocationApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(LocationApiApplication.class, args);
	}

}

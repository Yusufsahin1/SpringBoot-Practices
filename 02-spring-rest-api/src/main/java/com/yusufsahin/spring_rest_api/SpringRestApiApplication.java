package com.yusufsahin.spring_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.yusufsahin"})
@SpringBootApplication
public class SpringRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRestApiApplication.class, args);
	}

}

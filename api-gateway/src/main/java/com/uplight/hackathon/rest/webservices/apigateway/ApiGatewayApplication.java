package com.uplight.hackathon.rest.webservices.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @author Lokendra Singh
 * @date 19 March 2023
 * 
 * The class acts as API gateway and serves the purpose of request routing .
 *
 */
@SpringBootApplication
public class ApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiGatewayApplication.class, args);
	}

}

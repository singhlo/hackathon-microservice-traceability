package com.uplight.hackathon.rest.webservices.namingserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
* 
* @author Lokendra Singh
* @date 19 March 2023
* 
* The Bootstrap class acts as the entry point . 
* It also acts as a Eureka Naming server to serve for Micro Service registry/discovery.
*
*/

@SpringBootApplication
@EnableEurekaServer
public class NamingServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(NamingServerApplication.class, args);
	}

}

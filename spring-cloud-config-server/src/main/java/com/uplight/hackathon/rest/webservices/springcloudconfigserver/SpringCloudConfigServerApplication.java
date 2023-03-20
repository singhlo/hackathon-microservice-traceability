package com.uplight.hackathon.rest.webservices.springcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
/**
* 
* @author Lokendra Singh
* @date 19 March 2023
* 
* The Bootstrap class acts as the entry point. 
* Its responsible for auto Configurations, Bean definition and component scans.
* It also serves as Centralised configuration server for all other micro services.
*
*/

@EnableConfigServer
@SpringBootApplication
public class SpringCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerApplication.class, args);
	}

}

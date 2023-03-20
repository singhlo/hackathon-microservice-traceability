package com.uplight.hackathon.rest.webservices.currencyexchangeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
* 
* @author Lokendra Singh
* @date 19 March 2023
* 
* The Bootstrap class acts as the entry point for currency-exchange micro service. 
* Its responsible for auto Configurations, Bean definition and component scans.
*
*/

@SpringBootApplication
public class CurrencyExchangeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyExchangeServiceApplication.class, args);
	}

}

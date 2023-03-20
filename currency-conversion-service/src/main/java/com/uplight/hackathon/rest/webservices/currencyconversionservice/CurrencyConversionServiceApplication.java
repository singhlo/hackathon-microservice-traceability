package com.uplight.hackathon.rest.webservices.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
/**
 * 
 * @author Lokendra Singh
 * @date 19 March 2023
 * 
 * The Bootstrap class acts as the entry point for currency-conversion micro service. 
 * Its responsible for auto Configurations, Bean definition and component scans.
 *
 */

@SpringBootApplication
@EnableFeignClients
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

}

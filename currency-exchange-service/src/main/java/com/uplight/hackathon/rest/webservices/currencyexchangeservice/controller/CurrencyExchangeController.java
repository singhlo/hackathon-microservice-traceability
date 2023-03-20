package com.uplight.hackathon.rest.webservices.currencyexchangeservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.uplight.hackathon.rest.webservices.currencyexchangeservice.bean.CurrencyExchange;
import com.uplight.hackathon.rest.webservices.currencyexchangeservice.repository.controller.CurrencyExchangeRepository;

/**
 * 
 * @author Lokendra Singh
 * @date 19 March 2023
 * 
 * The controller class to expose currency-exchange micro service APIs.
 *
 */
@RestController
public class CurrencyExchangeController {
	@Autowired
	private Environment environment;
	@Autowired
	private CurrencyExchangeRepository currencyExchangeRepository;
	
	/**
	 * Retrives exchange rates from the database based on the type of currencies.
	 * 
	 * @param from
	 * @param to
	 * @return CurrencyExchange
	 */
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
		CurrencyExchange currencyExchange1 = currencyExchangeRepository.findByFromAndTo(from, to);
		if(currencyExchange1 == null) {
			throw new RuntimeException("Unable to find data for " + from + "And" + to);
		}
		CurrencyExchange currencyExchange=  new CurrencyExchange(1000L, from, to , BigDecimal.valueOf(65));
		String port = environment.getProperty("local.server.port");
		currencyExchange1.setEnvironment(port);
		return currencyExchange1;
	}

}

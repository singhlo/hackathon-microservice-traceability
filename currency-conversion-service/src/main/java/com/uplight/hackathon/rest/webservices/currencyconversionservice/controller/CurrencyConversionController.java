package com.uplight.hackathon.rest.webservices.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.uplight.hackathon.rest.webservices.currencyconversionservice.CurrencyExchangeProxy;
import com.uplight.hackathon.rest.webservices.currencyconversionservice.bean.CurrencyConversion;
/**
 * 
 * @author Lokendra Singh
 * @date 19 March 2023
 * 
 * The controller class to expose currency-conversion micro service APIs.
 *
 */

@RestController
public class CurrencyConversionController {
	@Autowired
	private CurrencyExchangeProxy proxy;
	
	/**
	 * 
	 * Retrieves the actual currency conversion details by applying  exchange rates.
	 * @param from
	 * @param to
	 * @param quantity
	 * @return CurrencyConversion
	 */
	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	CurrencyConversion retrieveCurrencyConversion(@PathVariable String from, @PathVariable String to, @PathVariable Long quantity) {
		CurrencyConversion response = proxy.retrieveExchangeValue(from, to);
		return new CurrencyConversion(response.getId(),from,  to , BigDecimal.valueOf(quantity), response.getConversionMultiple(),
				BigDecimal.valueOf(quantity).multiply(response.getConversionMultiple()),response.getEnvironment());
	}

}

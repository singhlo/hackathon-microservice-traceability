package com.uplight.hackathon.rest.webservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.uplight.hackathon.rest.webservices.currencyconversionservice.bean.CurrencyConversion;
/**
 * 
 * @author Lokendra Singh
 * @date 19 March 2023
 * 
 * The interface acts as Feign client to interact with currency-exchange micro service APIs.
 *
 */

@FeignClient(name="currency-exchange")
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExchangeValue(@PathVariable String from, @PathVariable String to);

}

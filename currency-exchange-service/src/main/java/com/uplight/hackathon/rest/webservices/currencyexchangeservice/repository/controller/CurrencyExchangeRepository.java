package com.uplight.hackathon.rest.webservices.currencyexchangeservice.repository.controller;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.uplight.hackathon.rest.webservices.currencyexchangeservice.bean.CurrencyExchange;

/**
 * 
 * @author Lokendra Singh
 * @date 19 March 2023
 * 
 * The repository interface to interact with currency_exchange database table.
 *
 */

@Repository
public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
	
	/**
	 * Find the exchange rate details based on currency types.
	 * 
	 * @param from
	 * @param to
	 * @return CurrencyExchange
	 */
	CurrencyExchange findByFromAndTo(String from, String to);
	

}

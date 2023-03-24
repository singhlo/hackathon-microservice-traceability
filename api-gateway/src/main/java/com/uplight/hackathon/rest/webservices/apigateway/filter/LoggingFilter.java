/**
 * 
 */
package com.uplight.hackathon.rest.webservices.apigateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

/**
 * Filter class to log each request coming through API gateway.
 * 
 * @author Lokendra Singh
 * @date 22 March 2023
 *
 */
@Component
public class LoggingFilter implements GlobalFilter {
	
	private Logger LOGGER = LoggerFactory.getLogger(LoggingFilter.class);

	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		LOGGER.info("Path of the request received -> {} ", 
				exchange.getRequest().getPath());
		return chain.filter(exchange);
	}

}

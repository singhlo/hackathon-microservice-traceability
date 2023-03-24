package com.uplight.hackathon.rest.webservices.apigateway;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.tracing.Tracer;
import io.micrometer.tracing.otel.bridge.OtelTracer;

/**
 * 
 * @author Lokendra Singh
 * @date 20 March 2023
 *
 */
@Configuration
public class ApiGatewayConfiguration {
	private final Tracer tracer = Tracer.NOOP;
	private static final Logger LOGGER = LoggerFactory.getLogger(ApiGatewayConfiguration.class);
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		Function<PredicateSpec, Buildable<Route>> routeFunction 
			=p -> p.path("/get")
					.filters(f -> f.addRequestHeader("MyHeader", "MyUri"))
					.uri("http://httpbin.org:80");
			String traceId = this.tracer.currentSpan().context().traceId();
	        LOGGER.info("<ACCEPTANCE_TEST> <TRACE:{}> Hello from producer", traceId);
		return builder.routes()
				.route(routeFunction).build();
	}
	
	/*
	 * @Bean MeterRegistryCustomizer meterRegistryCustomizer(MeterRegistry
	 * meterRegistry) { return registry -> {
	 * meterRegistry.config().commonTags("application", "name"); }; }
	 */

}

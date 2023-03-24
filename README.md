# hackathon-microservice-traceability
Its a hackathon pitch idea to have traceability implemented for microservices , using Spring boot, spring cloud, sleuth and zipkin

In order to see the traceability on zipkin 

	1. Make sure to have a stanalone zipkin server up , running and listening to port 9411 ( command : docker run openzipkin/zipkin:2.23)
	2. Start all the server/services in the same order mentioned below 
		Naming Server
		Currency Exchange
		Currency Conversion
		API-Gateway
	3. Hit the Eureka URL and ensure that all others are registered with Naming Server ( Eureka)

Important URLs :
	
	1. Eureka Naming server : http://localhost:8761/
	2. currency-exchange : http://localhost:8000/currency-exchange/from/USD/to/INR
	3. currency-conversion : http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	4. API Gateway : http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10
	
Below two URLs are the demostration of centralised configuration in cloud server and micro service picks up the properties from that server 
	
	5. Spring cloud config server : http://localhost:8888	
	6. limits-service : http://localhost:8081/limits

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
	4. Hit the API gateway URL.
	5. Access Zipkin server ( http://localhost:9411)
	6. Click on Run Query button to see the traces of API Gateway -> Currency-Conversion -> Currency-Exchange

Important URLs :
	
	1. Eureka Naming server : http://localhost:8761/
	2. currency-exchange : http://localhost:8000/currency-exchange/from/USD/to/INR
	3. currency-conversion : http://localhost:8100/currency-conversion/from/USD/to/INR/quantity/10
	4. API Gateway : http://localhost:8765/CURRENCY-CONVERSION/currency-conversion/from/USD/to/INR/quantity/10
	
Below two URLs are the demostration of centralised configuration in cloud server and micro service picks up the properties from that server 
	
	5. Spring cloud config server : http://localhost:8888	
	6. limits-service : http://localhost:8081/limits
	
In order to work with docker and docker compose :

	1. Make sure you have docker and docker compose installed on your linux/windows/mac box.
	2. Each service pom.xml need to be modified to have your docker.in userName, current it has my docker account user name .
		Reference :
			
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
				<configuration>
					<image>
						<name>loki007007/traceability-${project.artifactId}:${project.version}</name>
						<pullPolicy>IF_NOT_PRESENT</pullPolicy>
					</image>
				</configuration>
			</plugin>
	3. The same name(s) are to be updated in docker-compose.yaml file , in case you are trying to bounce all the component using docker compose .

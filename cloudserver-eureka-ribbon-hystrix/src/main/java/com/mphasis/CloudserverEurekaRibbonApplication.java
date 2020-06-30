package com.mphasis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class CloudserverEurekaRibbonApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudserverEurekaRibbonApplication.class, args);
	}

}

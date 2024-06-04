package com.microservice.dog_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroserviceDogApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceDogApiApplication.class, args);
	}

}

package com.microservice.placeholder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicePlaceholderApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicePlaceholderApplication.class, args);
	}

}

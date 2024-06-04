package com.microservice.dog_api.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class AbstractClient {
    @Value("${dogApi.base-url}")
    protected String dogApiBaseUrl;

    @Value("${dogApi.api-key}")
    protected String apiKey;

    protected final RestTemplate restTemplate;

    protected AbstractClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}

package com.microservice.placeholder.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

public class AbstractClient {
    @Value("${jsonPlaceHolder.base-url}")
    protected String jsonPlaceHolderBaseUrl;

    protected final RestTemplate restTemplate;

    protected AbstractClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
}

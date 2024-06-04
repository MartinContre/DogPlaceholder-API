package com.microservice.dog_api.service;

import com.microservice.dog_api.service.dto.Dog;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class DogServiceImpl extends AbstractClient implements DogService {

    public DogServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public List<Dog> findAllDogBreeds() {
        String uri = dogApiBaseUrl + "/breeds";
        HttpHeaders headers = new HttpHeaders();
        headers.set("x-api-key", apiKey);
        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<Dog[]> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity, Dog[].class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return Arrays.asList(response.getBody());
        }

        throw new RuntimeException("Failed to fetch dog breeds: " + response.getStatusCode());
    }
}

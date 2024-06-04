package com.microservice.dog_api.service;

import com.microservice.dog_api.service.dto.Dog;

import java.util.List;

public interface DogService {
    List<Dog> findAllDogBreeds();
}

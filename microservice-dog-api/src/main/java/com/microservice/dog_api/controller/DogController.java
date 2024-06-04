package com.microservice.dog_api.controller;

import com.microservice.dog_api.service.DogServiceImpl;
import com.microservice.dog_api.service.dto.Dog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/uvaq/api/dogs")
public class DogController {
    @Autowired
    private DogServiceImpl dogService;

    @GetMapping("/breeds")
    public List<Dog> getAllBreeds() {
        return dogService.findAllDogBreeds();
    }
}

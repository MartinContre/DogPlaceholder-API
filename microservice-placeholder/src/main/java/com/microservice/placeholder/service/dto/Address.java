package com.microservice.placeholder.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Address {
    private String street;
    private String suite;
    private String city;
    @JsonProperty("zipcode")
    private String zipCode;
    private Geo geo;
}

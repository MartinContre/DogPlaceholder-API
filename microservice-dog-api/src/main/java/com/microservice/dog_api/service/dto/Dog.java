package com.microservice.dog_api.service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Dog {
    private long id;
    private String name;

    @JsonProperty("bred_for")
    private String bredFor;

    @JsonProperty("breed_group")
    private String breedGroup;

    @JsonProperty("life_span")
    private String lifeSpan;

    private String temperament;
    private String origin;

    @JsonProperty("reference_image_id")
    private String referenceImageId;
}

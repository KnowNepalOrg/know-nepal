package com.knownepal.wildlife.dto.response;

import lombok.Data;

@Data
public class WildlifeSpeciesResponse {

    private Long id;
    private String slug;
    private String name;
    private String scientificName;
    private String description;
    private String classType;
    private String conservationStatus;
    private String nepalStatus;
    private String habitat;
    private String elevationRange;
    private String estimatedPopulation;
    private Boolean isEndemic;
    private Boolean isFeatured;
    private String funFacts;
}

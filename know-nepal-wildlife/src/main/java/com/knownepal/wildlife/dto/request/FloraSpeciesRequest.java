package com.knownepal.wildlife.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FloraSpeciesRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String scientificName;

    private String description;

    private String plantType;

    private String familyName;

    private String habitat;

    private String elevationRange;

    private Boolean isEndemic;

    private Boolean isMedicinal;

    private String medicinalUses;

    private String conservationStatus;

    private Boolean isFeatured;

    private String funFacts;
}

package com.knownepal.wildlife.dto.request;

import com.knownepal.wildlife.model.ClassType;
import com.knownepal.wildlife.model.ConservationStatus;
import com.knownepal.wildlife.model.NepalStatus;
import com.knownepal.wildlife.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class WildlifeSpeciesRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String scientificName;

    private String description;

    @NotBlank(message = "Class type is required")
    @ValidEnum(enumClass = ClassType.class)
    private String classType;

    @NotBlank(message = "Conservation status is required")
    @ValidEnum(enumClass = ConservationStatus.class)
    private String conservationStatus;

    @ValidEnum(enumClass = NepalStatus.class)
    private String nepalStatus;

    private String habitat;

    private String elevationRange;

    private String estimatedPopulation;

    private Boolean isEndemic;

    private Boolean isFeatured;

    private String funFacts;
}

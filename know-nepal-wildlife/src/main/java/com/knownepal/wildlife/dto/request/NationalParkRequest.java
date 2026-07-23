package com.knownepal.wildlife.dto.request;

import com.knownepal.wildlife.validator.ValidEnum;
import com.knownepal.wildlife.model.ProtectedAreaType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class NationalParkRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Area type is required")
    @ValidEnum(enumClass = ProtectedAreaType.class)
    private String areaType;

    private String district;

    private String province;

    private Double areaSqKm;

    private Double bufferZoneSqKm;

    private Integer establishedYear;

    private Integer elevationMinM;

    private Integer elevationMaxM;

    private String keySpecies;

    private String notableFeatures;

    private Integer visitorCount;

    private Boolean isFeatured;
}

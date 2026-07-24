package com.knownepal.history.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HistoricalEraRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Start year is required")
    private Integer startYear;

    private Integer endYear;

    private String keyCharacteristics;

    private Boolean isFeatured;
}

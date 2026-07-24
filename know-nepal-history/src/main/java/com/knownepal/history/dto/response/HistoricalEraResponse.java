package com.knownepal.history.dto.response;

import lombok.Data;

@Data
public class HistoricalEraResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private Integer startYear;
    private Integer endYear;
    private String keyCharacteristics;
    private Boolean isFeatured;
}

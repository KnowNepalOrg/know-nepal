package com.knownepal.wildlife.dto.response;

import lombok.Data;

@Data
public class NationalParkResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
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

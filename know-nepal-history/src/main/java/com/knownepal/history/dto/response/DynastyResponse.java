package com.knownepal.history.dto.response;

import lombok.Data;

@Data
public class DynastyResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private Long eraId;
    private String eraName;
    private Long founderId;
    private String founderName;
    private Integer startYear;
    private Integer endYear;
    private String capital;
    private String keyAchievements;
    private Integer numberOfRulers;
    private Boolean isFeatured;
}

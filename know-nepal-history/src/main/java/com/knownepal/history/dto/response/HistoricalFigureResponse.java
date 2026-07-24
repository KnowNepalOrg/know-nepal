package com.knownepal.history.dto.response;

import lombok.Data;

@Data
public class HistoricalFigureResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private String figureType;
    private Integer birthYear;
    private Integer deathYear;
    private String birthPlace;
    private String knownFor;
    private String keyAchievements;
    private String dynastyAffiliation;
    private String eraName;
    private Boolean isFeatured;
}

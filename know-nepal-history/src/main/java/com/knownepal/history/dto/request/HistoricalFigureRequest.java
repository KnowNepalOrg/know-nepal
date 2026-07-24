package com.knownepal.history.dto.request;

import com.knownepal.history.model.FigureType;
import com.knownepal.history.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HistoricalFigureRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Figure type is required")
    @ValidEnum(enumClass = FigureType.class, message = "must be a valid figure type")
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

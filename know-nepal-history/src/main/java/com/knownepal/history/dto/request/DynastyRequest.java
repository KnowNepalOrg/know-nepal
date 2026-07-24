package com.knownepal.history.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DynastyRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Era ID is required")
    private Long eraId;

    private Long founderId;

    private Integer startYear;

    private Integer endYear;

    private String capital;

    private String keyAchievements;

    private Integer numberOfRulers;

    private Boolean isFeatured;
}

package com.knownepal.destinations.dto.request;

import com.knownepal.destinations.model.BestSeason;
import com.knownepal.destinations.model.DifficultyLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DestinationItineraryRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Duration days is required")
    private Integer durationDays;

    private DifficultyLevel difficultyLevel;
    private BestSeason bestSeason;
    private Boolean isPopular;
}

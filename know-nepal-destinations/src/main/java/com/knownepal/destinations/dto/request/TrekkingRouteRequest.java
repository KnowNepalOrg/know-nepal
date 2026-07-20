package com.knownepal.destinations.dto.request;

import com.knownepal.destinations.model.BestSeason;
import com.knownepal.destinations.model.DifficultyLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TrekkingRouteRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Difficulty level is required")
    private DifficultyLevel difficultyLevel;

    private BigDecimal distanceKm;
    private Integer durationDays;
    private Integer maxAltitudeMeters;
    private BestSeason bestSeason;
    private Boolean isPopular;
    private List<Long> destinationIds;
}

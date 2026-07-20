package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.BestSeason;
import com.knownepal.destinations.model.DifficultyLevel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TrekkingRouteResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private DifficultyLevel difficultyLevel;
    private BigDecimal distanceKm;
    private Integer durationDays;
    private Integer maxAltitudeMeters;
    private BestSeason bestSeason;
    private Boolean isPopular;
    private List<RouteDestinationResponse> routeDestinations;
}

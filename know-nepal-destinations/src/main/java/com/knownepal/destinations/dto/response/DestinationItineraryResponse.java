package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.BestSeason;
import com.knownepal.destinations.model.DifficultyLevel;
import lombok.Data;

import java.util.List;

@Data
public class DestinationItineraryResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private Integer durationDays;
    private DifficultyLevel difficultyLevel;
    private BestSeason bestSeason;
    private Boolean isPopular;
    private List<ItineraryDayResponse> days;
}

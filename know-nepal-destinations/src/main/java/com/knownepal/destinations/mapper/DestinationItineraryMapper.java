package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.DestinationItineraryResponse;
import com.knownepal.destinations.model.DestinationItinerary;

import java.util.stream.Collectors;

public class DestinationItineraryMapper {

    private DestinationItineraryMapper() {
    }

    public static DestinationItineraryResponse toResponse(DestinationItinerary entity) {
        DestinationItineraryResponse response = new DestinationItineraryResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setDurationDays(entity.getDurationDays());
        response.setDifficultyLevel(entity.getDifficultyLevel());
        response.setBestSeason(entity.getBestSeason());
        response.setIsPopular(entity.getIsPopular());
        if (entity.getDays() != null) {
            response.setDays(
                    entity.getDays().stream()
                            .map(ItineraryDayMapper::toResponse)
                            .collect(Collectors.toList())
            );
        }
        return response;
    }
}

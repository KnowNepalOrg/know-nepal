package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.ItineraryDayResponse;
import com.knownepal.destinations.model.ItineraryDay;

import java.util.stream.Collectors;

public class ItineraryDayMapper {

    private ItineraryDayMapper() {
    }

    public static ItineraryDayResponse toResponse(ItineraryDay entity) {
        ItineraryDayResponse response = new ItineraryDayResponse();
        response.setId(entity.getId());
        response.setDayNumber(entity.getDayNumber());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setAccommodation(entity.getAccommodation());
        response.setMeals(entity.getMeals());
        response.setDistanceKm(entity.getDistanceKm());
        if (entity.getItinerary() != null) {
            response.setItineraryId(entity.getItinerary().getId());
        }
        if (entity.getDayDestinations() != null) {
            response.setDayDestinations(
                    entity.getDayDestinations().stream()
                            .map(ItineraryDayDestinationMapper::toResponse)
                            .collect(Collectors.toList())
            );
        }
        return response;
    }
}

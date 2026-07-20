package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.ItineraryDayDestinationResponse;
import com.knownepal.destinations.model.ItineraryDayDestination;

public class ItineraryDayDestinationMapper {

    private ItineraryDayDestinationMapper() {
    }

    public static ItineraryDayDestinationResponse toResponse(ItineraryDayDestination entity) {
        ItineraryDayDestinationResponse response = new ItineraryDayDestinationResponse();
        response.setId(entity.getId());
        response.setSequenceOrder(entity.getSequenceOrder());
        response.setNotes(entity.getNotes());
        if (entity.getDestination() != null) {
            response.setDestinationId(entity.getDestination().getId());
            response.setDestinationName(entity.getDestination().getName());
            response.setDestinationSlug(entity.getDestination().getSlug());
        }
        return response;
    }
}

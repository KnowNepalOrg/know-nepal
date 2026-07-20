package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.NearbyDestinationResponse;
import com.knownepal.destinations.model.NearbyDestination;

public class NearbyDestinationMapper {

    private NearbyDestinationMapper() {
    }

    public static NearbyDestinationResponse toResponse(NearbyDestination entity) {
        NearbyDestinationResponse response = new NearbyDestinationResponse();
        response.setId(entity.getId());
        response.setDistanceKm(entity.getDistanceKm());
        response.setTravelTimeMinutes(entity.getTravelTimeMinutes());
        response.setTravelMode(entity.getTravelMode());
        if (entity.getDestination() != null) {
            response.setDestinationId(entity.getDestination().getId());
        }
        if (entity.getNearbyDestination() != null) {
            response.setNearbyDestinationId(entity.getNearbyDestination().getId());
            response.setNearbyDestinationName(entity.getNearbyDestination().getName());
            response.setNearbyDestinationSlug(entity.getNearbyDestination().getSlug());
        }
        return response;
    }
}

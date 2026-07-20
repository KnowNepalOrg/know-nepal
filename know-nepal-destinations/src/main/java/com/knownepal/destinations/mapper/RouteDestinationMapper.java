package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.RouteDestinationResponse;
import com.knownepal.destinations.model.RouteDestination;

public class RouteDestinationMapper {

    private RouteDestinationMapper() {
    }

    public static RouteDestinationResponse toResponse(RouteDestination entity) {
        RouteDestinationResponse response = new RouteDestinationResponse();
        response.setId(entity.getId());
        response.setSequenceOrder(entity.getSequenceOrder());
        response.setIsOvernightStop(entity.getIsOvernightStop());
        if (entity.getDestination() != null) {
            response.setDestinationId(entity.getDestination().getId());
            response.setDestinationName(entity.getDestination().getName());
            response.setDestinationSlug(entity.getDestination().getSlug());
        }
        return response;
    }
}

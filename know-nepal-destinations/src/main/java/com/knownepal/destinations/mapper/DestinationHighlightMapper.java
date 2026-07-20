package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.DestinationHighlightResponse;
import com.knownepal.destinations.model.DestinationHighlight;

public class DestinationHighlightMapper {

    private DestinationHighlightMapper() {
    }

    public static DestinationHighlightResponse toResponse(DestinationHighlight entity) {
        DestinationHighlightResponse response = new DestinationHighlightResponse();
        response.setId(entity.getId());
        response.setTitle(entity.getTitle());
        response.setDescription(entity.getDescription());
        response.setDisplayOrder(entity.getDisplayOrder());
        if (entity.getDestination() != null) {
            response.setDestinationId(entity.getDestination().getId());
        }
        return response;
    }
}

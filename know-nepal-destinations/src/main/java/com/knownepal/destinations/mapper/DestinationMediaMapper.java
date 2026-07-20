package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.DestinationMediaResponse;
import com.knownepal.destinations.model.DestinationMedia;

public class DestinationMediaMapper {

    private DestinationMediaMapper() {
    }

    public static DestinationMediaResponse toResponse(DestinationMedia entity) {
        DestinationMediaResponse response = new DestinationMediaResponse();
        response.setId(entity.getId());
        response.setUrl(entity.getUrl());
        response.setCaption(entity.getCaption());
        response.setMediaType(entity.getMediaType());
        response.setDisplayOrder(entity.getDisplayOrder());
        response.setIsPrimary(entity.getIsPrimary());
        if (entity.getDestination() != null) {
            response.setDestinationId(entity.getDestination().getId());
        }
        return response;
    }
}

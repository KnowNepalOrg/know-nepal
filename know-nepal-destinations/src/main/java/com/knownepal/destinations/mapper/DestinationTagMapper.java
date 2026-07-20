package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.request.DestinationTagRequest;
import com.knownepal.destinations.dto.response.TagResponse;
import com.knownepal.destinations.model.DestinationTag;

public class DestinationTagMapper {

    private DestinationTagMapper() {
    }

    public static TagResponse toResponse(DestinationTag entity) {
        TagResponse response = new TagResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setTagType(entity.getTagType());
        return response;
    }

    public static DestinationTag toEntity(DestinationTagRequest request) {
        DestinationTag entity = new DestinationTag();
        entity.setName(request.getName());
        entity.setTagType(request.getTagType());
        return entity;
    }

    public static void updateEntity(DestinationTag entity, DestinationTagRequest request) {
        entity.setName(request.getName());
        entity.setTagType(request.getTagType());
    }
}

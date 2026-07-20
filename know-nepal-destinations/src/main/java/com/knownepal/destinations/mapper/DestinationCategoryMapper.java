package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.request.DestinationCategoryRequest;
import com.knownepal.destinations.dto.response.DestinationCategoryResponse;
import com.knownepal.destinations.model.DestinationCategory;

public class DestinationCategoryMapper {

    private DestinationCategoryMapper() {
    }

    public static DestinationCategoryResponse toResponse(DestinationCategory entity) {
        DestinationCategoryResponse response = new DestinationCategoryResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setIcon(entity.getIcon());
        response.setDisplayOrder(entity.getDisplayOrder());
        return response;
    }

    public static DestinationCategory toEntity(DestinationCategoryRequest request) {
        DestinationCategory entity = new DestinationCategory();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setIcon(request.getIcon());
        entity.setDisplayOrder(request.getDisplayOrder());
        return entity;
    }

    public static void updateEntity(DestinationCategory entity, DestinationCategoryRequest request) {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setIcon(request.getIcon());
        entity.setDisplayOrder(request.getDisplayOrder());
    }
}

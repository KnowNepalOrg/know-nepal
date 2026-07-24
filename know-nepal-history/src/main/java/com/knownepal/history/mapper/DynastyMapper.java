package com.knownepal.history.mapper;

import com.knownepal.history.dto.response.DynastyResponse;
import com.knownepal.history.model.Dynasty;

public class DynastyMapper {

    private DynastyMapper() {
    }

    public static DynastyResponse toResponse(Dynasty entity) {
        DynastyResponse response = new DynastyResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        if (entity.getEra() != null) {
            response.setEraId(entity.getEra().getId());
            response.setEraName(entity.getEra().getName());
        }
        if (entity.getFounder() != null) {
            response.setFounderId(entity.getFounder().getId());
            response.setFounderName(entity.getFounder().getName());
        }
        response.setStartYear(entity.getStartYear());
        response.setEndYear(entity.getEndYear());
        response.setCapital(entity.getCapital());
        response.setKeyAchievements(entity.getKeyAchievements());
        response.setNumberOfRulers(entity.getNumberOfRulers());
        response.setIsFeatured(entity.getIsFeatured());
        return response;
    }
}

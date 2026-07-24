package com.knownepal.history.mapper;

import com.knownepal.history.dto.response.HistoricalFigureResponse;
import com.knownepal.history.model.HistoricalFigure;

public class HistoricalFigureMapper {

    private HistoricalFigureMapper() {
    }

    public static HistoricalFigureResponse toResponse(HistoricalFigure entity) {
        HistoricalFigureResponse response = new HistoricalFigureResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setFigureType(entity.getFigureType() != null ? entity.getFigureType().name() : null);
        response.setBirthYear(entity.getBirthYear());
        response.setDeathYear(entity.getDeathYear());
        response.setBirthPlace(entity.getBirthPlace());
        response.setKnownFor(entity.getKnownFor());
        response.setKeyAchievements(entity.getKeyAchievements());
        response.setDynastyAffiliation(entity.getDynastyAffiliation());
        response.setEraName(entity.getEraName());
        response.setIsFeatured(entity.getIsFeatured());
        return response;
    }
}

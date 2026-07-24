package com.knownepal.history.mapper;

import com.knownepal.history.dto.response.HistoricalEraResponse;
import com.knownepal.history.model.HistoricalEra;

public class HistoricalEraMapper {

    private HistoricalEraMapper() {
    }

    public static HistoricalEraResponse toResponse(HistoricalEra entity) {
        HistoricalEraResponse response = new HistoricalEraResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setStartYear(entity.getStartYear());
        response.setEndYear(entity.getEndYear());
        response.setKeyCharacteristics(entity.getKeyCharacteristics());
        response.setIsFeatured(entity.getIsFeatured());
        return response;
    }
}

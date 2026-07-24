package com.knownepal.history.mapper;

import com.knownepal.history.dto.response.HistoricalEventResponse;
import com.knownepal.history.model.HistoricalEvent;

public class HistoricalEventMapper {

    private HistoricalEventMapper() {
    }

    public static HistoricalEventResponse toResponse(HistoricalEvent entity) {
        HistoricalEventResponse response = new HistoricalEventResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setEventType(entity.getEventType() != null ? entity.getEventType().name() : null);
        if (entity.getEra() != null) {
            response.setEraId(entity.getEra().getId());
            response.setEraName(entity.getEra().getName());
        }
        if (entity.getDynasty() != null) {
            response.setDynastyId(entity.getDynasty().getId());
            response.setDynastyName(entity.getDynasty().getName());
        }
        response.setEventYear(entity.getEventYear());
        response.setEndYear(entity.getEndYear());
        response.setLocation(entity.getLocation());
        response.setSignificance(entity.getSignificance());
        response.setKeyFiguresInvolved(entity.getKeyFiguresInvolved());
        response.setOutcome(entity.getOutcome());
        response.setIsFeatured(entity.getIsFeatured());
        return response;
    }
}

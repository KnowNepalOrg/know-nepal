package com.knownepal.culture.mapper;

import com.knownepal.culture.dto.response.LanguageResponse;
import com.knownepal.culture.model.Language;

public class LanguageMapper {

    private LanguageMapper() {
    }

    public static LanguageResponse toResponse(Language entity) {
        LanguageResponse response = new LanguageResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setLanguageFamily(entity.getLanguageFamily() != null ? entity.getLanguageFamily().name() : null);
        response.setLanguageStatus(entity.getLanguageStatus() != null ? entity.getLanguageStatus().name() : null);
        response.setSpeakersCount(entity.getSpeakersCount());
        response.setScript(entity.getScript());
        response.setWritingSystem(entity.getWritingSystem());
        response.setDialects(entity.getDialects());
        response.setIsOfficial(entity.getIsOfficial());
        response.setIsLinguaFranca(entity.getIsLinguaFranca());
        response.setRegionType(entity.getRegionType() != null ? entity.getRegionType().name() : null);
        response.setProvince(entity.getProvince());
        response.setOriginHistory(entity.getOriginHistory());
        response.setCulturalSignificance(entity.getCulturalSignificance());
        response.setEndangeredDetails(entity.getEndangeredDetails());
        response.setPreservationEfforts(entity.getPreservationEfforts());
        return response;
    }
}

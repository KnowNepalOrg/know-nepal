package com.knownepal.culture.mapper;

import com.knownepal.culture.dto.response.TraditionalAttireResponse;
import com.knownepal.culture.model.TraditionalAttire;

public class TraditionalAttireMapper {

    private TraditionalAttireMapper() {
    }

    public static TraditionalAttireResponse toResponse(TraditionalAttire entity) {
        TraditionalAttireResponse response = new TraditionalAttireResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setGenderType(entity.getGenderType() != null ? entity.getGenderType().name() : null);
        response.setAttireOccasion(entity.getAttireOccasion() != null ? entity.getAttireOccasion().name() : null);
        if (entity.getEthnicGroup() != null) {
            response.setEthnicGroupId(entity.getEthnicGroup().getId());
            response.setEthnicGroupName(entity.getEthnicGroup().getName());
        }
        response.setRegionType(entity.getRegionType() != null ? entity.getRegionType().name() : null);
        response.setProvince(entity.getProvince());
        response.setFabricMaterial(entity.getFabricMaterial());
        response.setColors(entity.getColors());
        response.setPatterns(entity.getPatterns());
        response.setSignificance(entity.getSignificance());
        response.setWearingOccasion(entity.getWearingOccasion());
        response.setHistoricalOrigin(entity.getHistoricalOrigin());
        response.setRegionalVariations(entity.getRegionalVariations());
        return response;
    }
}

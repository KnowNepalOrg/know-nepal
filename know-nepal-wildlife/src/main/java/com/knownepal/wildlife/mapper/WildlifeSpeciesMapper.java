package com.knownepal.wildlife.mapper;

import com.knownepal.wildlife.dto.response.WildlifeSpeciesResponse;
import com.knownepal.wildlife.model.WildlifeSpecies;

public class WildlifeSpeciesMapper {

    private WildlifeSpeciesMapper() {
    }

    public static WildlifeSpeciesResponse toResponse(WildlifeSpecies entity) {
        WildlifeSpeciesResponse response = new WildlifeSpeciesResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setScientificName(entity.getScientificName());
        response.setDescription(entity.getDescription());
        response.setClassType(entity.getClassType() != null ? entity.getClassType().name() : null);
        response.setConservationStatus(entity.getConservationStatus() != null ? entity.getConservationStatus().name() : null);
        response.setNepalStatus(entity.getNepalStatus() != null ? entity.getNepalStatus().name() : null);
        response.setHabitat(entity.getHabitat());
        response.setElevationRange(entity.getElevationRange());
        response.setEstimatedPopulation(entity.getEstimatedPopulation());
        response.setIsEndemic(entity.getIsEndemic());
        response.setIsFeatured(entity.getIsFeatured());
        response.setFunFacts(entity.getFunFacts());
        return response;
    }
}

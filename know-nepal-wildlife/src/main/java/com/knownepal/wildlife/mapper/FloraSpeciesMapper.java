package com.knownepal.wildlife.mapper;

import com.knownepal.wildlife.dto.response.FloraSpeciesResponse;
import com.knownepal.wildlife.model.FloraSpecies;

public class FloraSpeciesMapper {

    private FloraSpeciesMapper() {
    }

    public static FloraSpeciesResponse toResponse(FloraSpecies entity) {
        FloraSpeciesResponse response = new FloraSpeciesResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setScientificName(entity.getScientificName());
        response.setDescription(entity.getDescription());
        response.setPlantType(entity.getPlantType());
        response.setFamilyName(entity.getFamilyName());
        response.setHabitat(entity.getHabitat());
        response.setElevationRange(entity.getElevationRange());
        response.setIsEndemic(entity.getIsEndemic());
        response.setIsMedicinal(entity.getIsMedicinal());
        response.setMedicinalUses(entity.getMedicinalUses());
        response.setConservationStatus(entity.getConservationStatus());
        response.setIsFeatured(entity.getIsFeatured());
        response.setFunFacts(entity.getFunFacts());
        return response;
    }
}

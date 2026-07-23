package com.knownepal.wildlife.mapper;

import com.knownepal.wildlife.dto.response.NationalParkResponse;
import com.knownepal.wildlife.model.NationalPark;

public class NationalParkMapper {

    private NationalParkMapper() {
    }

    public static NationalParkResponse toResponse(NationalPark entity) {
        NationalParkResponse response = new NationalParkResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setAreaType(entity.getAreaType() != null ? entity.getAreaType().name() : null);
        response.setDistrict(entity.getDistrict());
        response.setProvince(entity.getProvince());
        response.setAreaSqKm(entity.getAreaSqKm());
        response.setBufferZoneSqKm(entity.getBufferZoneSqKm());
        response.setEstablishedYear(entity.getEstablishedYear());
        response.setElevationMinM(entity.getElevationMinM());
        response.setElevationMaxM(entity.getElevationMaxM());
        response.setKeySpecies(entity.getKeySpecies());
        response.setNotableFeatures(entity.getNotableFeatures());
        response.setVisitorCount(entity.getVisitorCount());
        response.setIsFeatured(entity.getIsFeatured());
        return response;
    }
}

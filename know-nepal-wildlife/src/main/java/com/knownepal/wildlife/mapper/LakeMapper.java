package com.knownepal.wildlife.mapper;

import com.knownepal.wildlife.dto.response.LakeResponse;
import com.knownepal.wildlife.model.Lake;

public class LakeMapper {

    private LakeMapper() {
    }

    public static LakeResponse toResponse(Lake entity) {
        LakeResponse response = new LakeResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setLakeType(entity.getLakeType() != null ? entity.getLakeType().name() : null);
        response.setDistrict(entity.getDistrict());
        response.setProvince(entity.getProvince());
        response.setMunicipality(entity.getMunicipality());
        response.setLatitude(entity.getLatitude());
        response.setLongitude(entity.getLongitude());
        response.setElevationM(entity.getElevationM());
        response.setAreaSqKm(entity.getAreaSqKm());
        response.setMaxDepthM(entity.getMaxDepthM());
        response.setLengthKm(entity.getLengthKm());
        response.setWidthKm(entity.getWidthKm());
        response.setHowToReach(entity.getHowToReach());
        response.setBestSeason(entity.getBestSeason());
        response.setEntryFeeNpr(entity.getEntryFeeNpr());
        response.setContactInfo(entity.getContactInfo());
        response.setImageUrl(entity.getImageUrl());
        response.setPhotos(entity.getPhotos());
        response.setNotableFeatures(entity.getNotableFeatures());
        response.setIsFeatured(entity.getIsFeatured());
        return response;
    }
}

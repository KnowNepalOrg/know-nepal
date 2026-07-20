package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.request.TouristDestinationRequest;
import com.knownepal.destinations.dto.response.TouristDestinationResponse;
import com.knownepal.destinations.model.TouristDestination;

public class TouristDestinationMapper {

    private TouristDestinationMapper() {
    }

    public static TouristDestinationResponse toResponse(TouristDestination entity) {
        TouristDestinationResponse response = new TouristDestinationResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setDestinationType(entity.getDestinationType());
        response.setProvinceId(entity.getProvinceId());
        response.setProvinceName(entity.getProvinceName());
        response.setDistrictId(entity.getDistrictId());
        response.setDistrictName(entity.getDistrictName());
        response.setMunicipalityId(entity.getMunicipalityId());
        response.setMunicipalityName(entity.getMunicipalityName());
        response.setLatitude(entity.getLatitude());
        response.setLongitude(entity.getLongitude());
        response.setAltitudeMeters(entity.getAltitudeMeters());
        response.setDifficultyLevel(entity.getDifficultyLevel());
        response.setBestSeason(entity.getBestSeason());
        response.setEntryFeeNpr(entity.getEntryFeeNpr());
        response.setVisitDuration(entity.getVisitDuration());
        response.setIsPopular(entity.getIsPopular());
        response.setIsFeatured(entity.getIsFeatured());
        if (entity.getCategory() != null) {
            response.setCategoryId(entity.getCategory().getId());
            response.setCategoryName(entity.getCategory().getName());
        }
        return response;
    }

    public static TouristDestination toEntity(TouristDestinationRequest request) {
        TouristDestination entity = new TouristDestination();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setDestinationType(request.getDestinationType());
        entity.setProvinceId(request.getProvinceId());
        entity.setProvinceName(request.getProvinceName());
        entity.setDistrictId(request.getDistrictId());
        entity.setDistrictName(request.getDistrictName());
        entity.setMunicipalityId(request.getMunicipalityId());
        entity.setMunicipalityName(request.getMunicipalityName());
        entity.setLatitude(request.getLatitude());
        entity.setLongitude(request.getLongitude());
        entity.setAltitudeMeters(request.getAltitudeMeters());
        entity.setDifficultyLevel(request.getDifficultyLevel());
        entity.setBestSeason(request.getBestSeason());
        entity.setEntryFeeNpr(request.getEntryFeeNpr());
        entity.setVisitDuration(request.getVisitDuration());
        entity.setIsPopular(request.getIsPopular() != null ? request.getIsPopular() : false);
        entity.setIsFeatured(request.getIsFeatured() != null ? request.getIsFeatured() : false);
        return entity;
    }

    public static void updateEntity(TouristDestination entity, TouristDestinationRequest request) {
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setDestinationType(request.getDestinationType());
        entity.setProvinceId(request.getProvinceId());
        entity.setProvinceName(request.getProvinceName());
        entity.setDistrictId(request.getDistrictId());
        entity.setDistrictName(request.getDistrictName());
        entity.setMunicipalityId(request.getMunicipalityId());
        entity.setMunicipalityName(request.getMunicipalityName());
        entity.setLatitude(request.getLatitude());
        entity.setLongitude(request.getLongitude());
        entity.setAltitudeMeters(request.getAltitudeMeters());
        entity.setDifficultyLevel(request.getDifficultyLevel());
        entity.setBestSeason(request.getBestSeason());
        entity.setEntryFeeNpr(request.getEntryFeeNpr());
        entity.setVisitDuration(request.getVisitDuration());
        entity.setIsPopular(request.getIsPopular() != null ? request.getIsPopular() : entity.getIsPopular());
        entity.setIsFeatured(request.getIsFeatured() != null ? request.getIsFeatured() : entity.getIsFeatured());
    }
}

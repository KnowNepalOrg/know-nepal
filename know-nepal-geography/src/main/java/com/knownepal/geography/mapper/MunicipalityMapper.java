package com.knownepal.geography.mapper;

import com.knownepal.geography.dto.request.MunicipalityRequest;
import com.knownepal.geography.dto.response.MunicipalityResponse;
import com.knownepal.geography.model.Municipality;

public final class MunicipalityMapper {

    private MunicipalityMapper() {
    }

    public static Municipality toEntity(MunicipalityRequest request) {
        if (request == null) {
            return null;
        }
        return Municipality.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .code(request.getCode())
                .type(request.getType())
                .area(request.getArea())
                .population(request.getPopulation())
                .wardCount(request.getWardCount())
                .slug(request.getSlug())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .elevation(request.getElevation())
                .description(request.getDescription())
                .websiteUrl(request.getWebsiteUrl())
                .contactPhone(request.getContactPhone())
                .contactEmail(request.getContactEmail())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static MunicipalityResponse toResponse(Municipality municipality) {
        if (municipality == null) {
            return null;
        }
        return new MunicipalityResponse(
                municipality.getId(),
                municipality.getName(),
                municipality.getNameNepali(),
                municipality.getCode(),
                municipality.getSlug(),
                municipality.getType(),
                municipality.getArea(),
                municipality.getPopulation(),
                municipality.getWardCount(),
                municipality.getLatitude(),
                municipality.getLongitude(),
                municipality.getElevation(),
                municipality.getDescription(),
                municipality.getWebsiteUrl(),
                municipality.getContactPhone(),
                municipality.getContactEmail(),
                municipality.getImageUrl(),
                municipality.getDistrict() != null ? municipality.getDistrict().getId() : null,
                municipality.getDistrict() != null ? municipality.getDistrict().getName() : null,
                municipality.getDistrict() != null && municipality.getDistrict().getProvince() != null
                        ? municipality.getDistrict().getProvince().getId() : null,
                municipality.getDistrict() != null && municipality.getDistrict().getProvince() != null
                        ? municipality.getDistrict().getProvince().getName() : null,
                municipality.getCreatedAt(),
                municipality.getUpdatedAt()
        );
    }

    public static void updateEntity(Municipality municipality, MunicipalityRequest request) {
        if (request.getName() != null) {
            municipality.setName(request.getName());
        }
        if (request.getNameNepali() != null) {
            municipality.setNameNepali(request.getNameNepali());
        }
        if (request.getCode() != null) {
            municipality.setCode(request.getCode());
        }
        if (request.getType() != null) {
            municipality.setType(request.getType());
        }
        if (request.getArea() != null) {
            municipality.setArea(request.getArea());
        }
        if (request.getPopulation() != null) {
            municipality.setPopulation(request.getPopulation());
        }
        if (request.getWardCount() != null) {
            municipality.setWardCount(request.getWardCount());
        }
        if (request.getSlug() != null) {
            municipality.setSlug(request.getSlug());
        }
        if (request.getLatitude() != null) {
            municipality.setLatitude(request.getLatitude());
        }
        if (request.getLongitude() != null) {
            municipality.setLongitude(request.getLongitude());
        }
        if (request.getElevation() != null) {
            municipality.setElevation(request.getElevation());
        }
        if (request.getDescription() != null) {
            municipality.setDescription(request.getDescription());
        }
        if (request.getWebsiteUrl() != null) {
            municipality.setWebsiteUrl(request.getWebsiteUrl());
        }
        if (request.getContactPhone() != null) {
            municipality.setContactPhone(request.getContactPhone());
        }
        if (request.getContactEmail() != null) {
            municipality.setContactEmail(request.getContactEmail());
        }
        if (request.getImageUrl() != null) {
            municipality.setImageUrl(request.getImageUrl());
        }
    }
}

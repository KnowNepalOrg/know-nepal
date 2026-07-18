package com.knownepal.geography.mapper;

import com.knownepal.geography.dto.request.DistrictRequest;
import com.knownepal.geography.dto.response.DistrictResponse;
import com.knownepal.geography.model.District;

public final class DistrictMapper {

    private DistrictMapper() {
    }

    public static District toEntity(DistrictRequest request) {
        if (request == null) {
            return null;
        }
        return District.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .code(request.getCode())
                .area(request.getArea())
                .population(request.getPopulation())
                .headquarters(request.getHeadquarters())
                .slug(request.getSlug())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .description(request.getDescription())
                .websiteUrl(request.getWebsiteUrl())
                .contactPhone(request.getContactPhone())
                .contactEmail(request.getContactEmail())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static DistrictResponse toResponse(District district) {
        if (district == null) {
            return null;
        }
        return new DistrictResponse(
                district.getId(),
                district.getName(),
                district.getNameNepali(),
                district.getCode(),
                district.getSlug(),
                district.getArea(),
                district.getPopulation(),
                district.getHeadquarters(),
                district.getLatitude(),
                district.getLongitude(),
                district.getDescription(),
                district.getWebsiteUrl(),
                district.getContactPhone(),
                district.getContactEmail(),
                district.getImageUrl(),
                district.getProvince() != null ? district.getProvince().getId() : null,
                district.getProvince() != null ? district.getProvince().getName() : null,
                district.getCreatedAt(),
                district.getUpdatedAt()
        );
    }

    public static void updateEntity(District district, DistrictRequest request) {
        if (request.getName() != null) {
            district.setName(request.getName());
        }
        if (request.getNameNepali() != null) {
            district.setNameNepali(request.getNameNepali());
        }
        if (request.getCode() != null) {
            district.setCode(request.getCode());
        }
        if (request.getArea() != null) {
            district.setArea(request.getArea());
        }
        if (request.getPopulation() != null) {
            district.setPopulation(request.getPopulation());
        }
        if (request.getHeadquarters() != null) {
            district.setHeadquarters(request.getHeadquarters());
        }
        if (request.getSlug() != null) {
            district.setSlug(request.getSlug());
        }
        if (request.getLatitude() != null) {
            district.setLatitude(request.getLatitude());
        }
        if (request.getLongitude() != null) {
            district.setLongitude(request.getLongitude());
        }
        if (request.getDescription() != null) {
            district.setDescription(request.getDescription());
        }
        if (request.getWebsiteUrl() != null) {
            district.setWebsiteUrl(request.getWebsiteUrl());
        }
        if (request.getContactPhone() != null) {
            district.setContactPhone(request.getContactPhone());
        }
        if (request.getContactEmail() != null) {
            district.setContactEmail(request.getContactEmail());
        }
        if (request.getImageUrl() != null) {
            district.setImageUrl(request.getImageUrl());
        }
    }
}

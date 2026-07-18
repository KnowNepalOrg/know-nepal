package com.knownepal.geography.mapper;

import com.knownepal.geography.dto.request.ProvinceRequest;
import com.knownepal.geography.dto.response.ProvinceResponse;
import com.knownepal.geography.model.Province;

public final class ProvinceMapper {

    private ProvinceMapper() {
    }

    public static Province toEntity(ProvinceRequest request) {
        if (request == null) {
            return null;
        }
        return Province.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .code(request.getCode())
                .area(request.getArea())
                .population(request.getPopulation())
                .capital(request.getCapital())
                .numberOfDistricts(request.getNumberOfDistricts())
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

    public static ProvinceResponse toResponse(Province province) {
        if (province == null) {
            return null;
        }
        return new ProvinceResponse(
                province.getId(),
                province.getName(),
                province.getNameNepali(),
                province.getCode(),
                province.getSlug(),
                province.getArea(),
                province.getPopulation(),
                province.getCapital(),
                province.getNumberOfDistricts(),
                province.getLatitude(),
                province.getLongitude(),
                province.getDescription(),
                province.getWebsiteUrl(),
                province.getContactPhone(),
                province.getContactEmail(),
                province.getImageUrl(),
                province.getCreatedAt(),
                province.getUpdatedAt()
        );
    }

    public static void updateEntity(Province province, ProvinceRequest request) {
        if (request.getName() != null) {
            province.setName(request.getName());
        }
        if (request.getNameNepali() != null) {
            province.setNameNepali(request.getNameNepali());
        }
        if (request.getCode() != null) {
            province.setCode(request.getCode());
        }
        if (request.getArea() != null) {
            province.setArea(request.getArea());
        }
        if (request.getPopulation() != null) {
            province.setPopulation(request.getPopulation());
        }
        if (request.getCapital() != null) {
            province.setCapital(request.getCapital());
        }
        if (request.getNumberOfDistricts() != null) {
            province.setNumberOfDistricts(request.getNumberOfDistricts());
        }
        if (request.getSlug() != null) {
            province.setSlug(request.getSlug());
        }
        if (request.getLatitude() != null) {
            province.setLatitude(request.getLatitude());
        }
        if (request.getLongitude() != null) {
            province.setLongitude(request.getLongitude());
        }
        if (request.getDescription() != null) {
            province.setDescription(request.getDescription());
        }
        if (request.getWebsiteUrl() != null) {
            province.setWebsiteUrl(request.getWebsiteUrl());
        }
        if (request.getContactPhone() != null) {
            province.setContactPhone(request.getContactPhone());
        }
        if (request.getContactEmail() != null) {
            province.setContactEmail(request.getContactEmail());
        }
        if (request.getImageUrl() != null) {
            province.setImageUrl(request.getImageUrl());
        }
    }
}

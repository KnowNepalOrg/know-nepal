package com.knownepal.geography.mapper;

import com.knownepal.geography.dto.request.WardRequest;
import com.knownepal.geography.dto.response.WardResponse;
import com.knownepal.geography.model.Ward;

public final class WardMapper {

    private WardMapper() {
    }

    public static Ward toEntity(WardRequest request) {
        if (request == null) {
            return null;
        }
        return Ward.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .number(request.getNumber())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .elevation(request.getElevation())
                .area(request.getArea())
                .population(request.getPopulation())
                .description(request.getDescription())
                .slug(request.getSlug())
                .contactPhone(request.getContactPhone())
                .contactEmail(request.getContactEmail())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static WardResponse toResponse(Ward ward) {
        if (ward == null) {
            return null;
        }
        return new WardResponse(
                ward.getId(),
                ward.getName(),
                ward.getNameNepali(),
                ward.getNumber(),
                ward.getSlug(),
                ward.getLatitude(),
                ward.getLongitude(),
                ward.getElevation(),
                ward.getArea(),
                ward.getPopulation(),
                ward.getDescription(),
                ward.getContactPhone(),
                ward.getContactEmail(),
                ward.getImageUrl(),
                ward.getMunicipality() != null ? ward.getMunicipality().getId() : null,
                ward.getMunicipality() != null ? ward.getMunicipality().getName() : null,
                ward.getMunicipality() != null && ward.getMunicipality().getDistrict() != null
                        ? ward.getMunicipality().getDistrict().getId() : null,
                ward.getMunicipality() != null && ward.getMunicipality().getDistrict() != null
                        ? ward.getMunicipality().getDistrict().getName() : null,
                ward.getMunicipality() != null && ward.getMunicipality().getDistrict() != null
                        && ward.getMunicipality().getDistrict().getProvince() != null
                        ? ward.getMunicipality().getDistrict().getProvince().getId() : null,
                ward.getMunicipality() != null && ward.getMunicipality().getDistrict() != null
                        && ward.getMunicipality().getDistrict().getProvince() != null
                        ? ward.getMunicipality().getDistrict().getProvince().getName() : null,
                ward.getCreatedAt(),
                ward.getUpdatedAt()
        );
    }

    public static void updateEntity(Ward ward, WardRequest request) {
        if (request.getName() != null) {
            ward.setName(request.getName());
        }
        if (request.getNameNepali() != null) {
            ward.setNameNepali(request.getNameNepali());
        }
        if (request.getNumber() != null) {
            ward.setNumber(request.getNumber());
        }
        if (request.getLatitude() != null) {
            ward.setLatitude(request.getLatitude());
        }
        if (request.getLongitude() != null) {
            ward.setLongitude(request.getLongitude());
        }
        if (request.getElevation() != null) {
            ward.setElevation(request.getElevation());
        }
        if (request.getArea() != null) {
            ward.setArea(request.getArea());
        }
        if (request.getPopulation() != null) {
            ward.setPopulation(request.getPopulation());
        }
        if (request.getDescription() != null) {
            ward.setDescription(request.getDescription());
        }
        if (request.getSlug() != null) {
            ward.setSlug(request.getSlug());
        }
        if (request.getContactPhone() != null) {
            ward.setContactPhone(request.getContactPhone());
        }
        if (request.getContactEmail() != null) {
            ward.setContactEmail(request.getContactEmail());
        }
        if (request.getImageUrl() != null) {
            ward.setImageUrl(request.getImageUrl());
        }
    }
}

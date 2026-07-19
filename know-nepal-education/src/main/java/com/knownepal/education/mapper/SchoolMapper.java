package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.SchoolRequest;
import com.knownepal.education.dto.response.SchoolResponse;
import com.knownepal.education.model.School;

public final class SchoolMapper {

    private SchoolMapper() {
    }

    public static School toEntity(SchoolRequest request) {
        if (request == null) return null;
        return School.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .slug(request.getSlug())
                .code(request.getCode())
                .type(request.getType())
                .level(request.getLevel())
                .establishedYear(request.getEstablishedYear())
                .affiliation(request.getAffiliation())
                .studentCount(request.getStudentCount())
                .teacherCount(request.getTeacherCount())
                .areaSqKm(request.getAreaSqKm())
                .description(request.getDescription())
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .elevation(request.getElevation())
                .provinceId(request.getProvinceId())
                .provinceName(request.getProvinceName())
                .districtId(request.getDistrictId())
                .districtName(request.getDistrictName())
                .municipalityId(request.getMunicipalityId())
                .municipalityName(request.getMunicipalityName())
                .wardId(request.getWardId())
                .wardName(request.getWardName())
                .address(request.getAddress())
                .phone(request.getPhone())
                .email(request.getEmail())
                .website(request.getWebsite())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static SchoolResponse toResponse(School school) {
        if (school == null) return null;
        return new SchoolResponse(
                school.getId(), school.getName(), school.getNameNepali(),
                school.getSlug(), school.getCode(), school.getType(), school.getLevel(),
                school.getEstablishedYear(), school.getAffiliation(),
                school.getStudentCount(), school.getTeacherCount(), school.getAreaSqKm(),
                school.getDescription(), school.getLatitude(), school.getLongitude(), school.getElevation(),
                school.getProvinceId(), school.getProvinceName(),
                school.getDistrictId(), school.getDistrictName(),
                school.getMunicipalityId(), school.getMunicipalityName(),
                school.getWardId(), school.getWardName(),
                school.getAddress(), school.getPhone(), school.getEmail(), school.getWebsite(),
                school.getImageUrl(), school.getCreatedAt(), school.getUpdatedAt()
        );
    }

    public static void updateEntity(School school, SchoolRequest request) {
        if (request.getName() != null) school.setName(request.getName());
        if (request.getNameNepali() != null) school.setNameNepali(request.getNameNepali());
        if (request.getSlug() != null) school.setSlug(request.getSlug());
        if (request.getCode() != null) school.setCode(request.getCode());
        if (request.getType() != null) school.setType(request.getType());
        if (request.getLevel() != null) school.setLevel(request.getLevel());
        if (request.getEstablishedYear() != null) school.setEstablishedYear(request.getEstablishedYear());
        if (request.getAffiliation() != null) school.setAffiliation(request.getAffiliation());
        if (request.getStudentCount() != null) school.setStudentCount(request.getStudentCount());
        if (request.getTeacherCount() != null) school.setTeacherCount(request.getTeacherCount());
        if (request.getAreaSqKm() != null) school.setAreaSqKm(request.getAreaSqKm());
        if (request.getDescription() != null) school.setDescription(request.getDescription());
        if (request.getLatitude() != null) school.setLatitude(request.getLatitude());
        if (request.getLongitude() != null) school.setLongitude(request.getLongitude());
        if (request.getElevation() != null) school.setElevation(request.getElevation());
        if (request.getProvinceId() != null) school.setProvinceId(request.getProvinceId());
        if (request.getProvinceName() != null) school.setProvinceName(request.getProvinceName());
        if (request.getDistrictId() != null) school.setDistrictId(request.getDistrictId());
        if (request.getDistrictName() != null) school.setDistrictName(request.getDistrictName());
        if (request.getMunicipalityId() != null) school.setMunicipalityId(request.getMunicipalityId());
        if (request.getMunicipalityName() != null) school.setMunicipalityName(request.getMunicipalityName());
        if (request.getWardId() != null) school.setWardId(request.getWardId());
        if (request.getWardName() != null) school.setWardName(request.getWardName());
        if (request.getAddress() != null) school.setAddress(request.getAddress());
        if (request.getPhone() != null) school.setPhone(request.getPhone());
        if (request.getEmail() != null) school.setEmail(request.getEmail());
        if (request.getWebsite() != null) school.setWebsite(request.getWebsite());
        if (request.getImageUrl() != null) school.setImageUrl(request.getImageUrl());
    }
}

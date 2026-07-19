package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.CollegeRequest;
import com.knownepal.education.dto.response.CollegeResponse;
import com.knownepal.education.model.College;

public final class CollegeMapper {

    private CollegeMapper() {
    }

    public static College toEntity(CollegeRequest request) {
        if (request == null) return null;
        return College.builder()
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
                .facilities(request.getFacilities())
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

    public static CollegeResponse toResponse(College college) {
        if (college == null) return null;
        return new CollegeResponse(
                college.getId(), college.getName(), college.getNameNepali(),
                college.getSlug(), college.getCode(), college.getType(), college.getLevel(),
                college.getEstablishedYear(), college.getAffiliation(),
                college.getStudentCount(), college.getTeacherCount(), college.getFacilities(),
                college.getDescription(), college.getLatitude(), college.getLongitude(), college.getElevation(),
                college.getProvinceId(), college.getProvinceName(),
                college.getDistrictId(), college.getDistrictName(),
                college.getMunicipalityId(), college.getMunicipalityName(),
                college.getWardId(), college.getWardName(),
                college.getAddress(), college.getPhone(), college.getEmail(), college.getWebsite(),
                college.getImageUrl(), college.getCreatedAt(), college.getUpdatedAt()
        );
    }

    public static void updateEntity(College college, CollegeRequest request) {
        if (request.getName() != null) college.setName(request.getName());
        if (request.getNameNepali() != null) college.setNameNepali(request.getNameNepali());
        if (request.getSlug() != null) college.setSlug(request.getSlug());
        if (request.getCode() != null) college.setCode(request.getCode());
        if (request.getType() != null) college.setType(request.getType());
        if (request.getLevel() != null) college.setLevel(request.getLevel());
        if (request.getEstablishedYear() != null) college.setEstablishedYear(request.getEstablishedYear());
        if (request.getAffiliation() != null) college.setAffiliation(request.getAffiliation());
        if (request.getStudentCount() != null) college.setStudentCount(request.getStudentCount());
        if (request.getTeacherCount() != null) college.setTeacherCount(request.getTeacherCount());
        if (request.getFacilities() != null) college.setFacilities(request.getFacilities());
        if (request.getDescription() != null) college.setDescription(request.getDescription());
        if (request.getLatitude() != null) college.setLatitude(request.getLatitude());
        if (request.getLongitude() != null) college.setLongitude(request.getLongitude());
        if (request.getElevation() != null) college.setElevation(request.getElevation());
        if (request.getProvinceId() != null) college.setProvinceId(request.getProvinceId());
        if (request.getProvinceName() != null) college.setProvinceName(request.getProvinceName());
        if (request.getDistrictId() != null) college.setDistrictId(request.getDistrictId());
        if (request.getDistrictName() != null) college.setDistrictName(request.getDistrictName());
        if (request.getMunicipalityId() != null) college.setMunicipalityId(request.getMunicipalityId());
        if (request.getMunicipalityName() != null) college.setMunicipalityName(request.getMunicipalityName());
        if (request.getWardId() != null) college.setWardId(request.getWardId());
        if (request.getWardName() != null) college.setWardName(request.getWardName());
        if (request.getAddress() != null) college.setAddress(request.getAddress());
        if (request.getPhone() != null) college.setPhone(request.getPhone());
        if (request.getEmail() != null) college.setEmail(request.getEmail());
        if (request.getWebsite() != null) college.setWebsite(request.getWebsite());
        if (request.getImageUrl() != null) college.setImageUrl(request.getImageUrl());
    }
}

package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.UniversityRequest;
import com.knownepal.education.dto.response.UniversityResponse;
import com.knownepal.education.model.University;

public final class UniversityMapper {

    private UniversityMapper() {
    }

    public static University toEntity(UniversityRequest request) {
        if (request == null) return null;
        return University.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .slug(request.getSlug())
                .code(request.getCode())
                .type(request.getType())
                .establishedYear(request.getEstablishedYear())
                .viceChancellor(request.getViceChancellor())
                .studentCount(request.getStudentCount())
                .facultyCount(request.getFacultyCount())
                .campusCount(request.getCampusCount())
                .affiliatedColleges(request.getAffiliatedColleges())
                .faculties(request.getFaculties())
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

    public static UniversityResponse toResponse(University university) {
        if (university == null) return null;
        return new UniversityResponse(
                university.getId(), university.getName(), university.getNameNepali(),
                university.getSlug(), university.getCode(), university.getType(),
                university.getEstablishedYear(), university.getViceChancellor(),
                university.getStudentCount(), university.getFacultyCount(),
                university.getCampusCount(), university.getAffiliatedColleges(),
                university.getFaculties(), university.getDescription(),
                university.getLatitude(), university.getLongitude(), university.getElevation(),
                university.getProvinceId(), university.getProvinceName(),
                university.getDistrictId(), university.getDistrictName(),
                university.getMunicipalityId(), university.getMunicipalityName(),
                university.getWardId(), university.getWardName(),
                university.getAddress(), university.getPhone(), university.getEmail(),
                university.getWebsite(), university.getImageUrl(),
                university.getCreatedAt(), university.getUpdatedAt()
        );
    }

    public static void updateEntity(University university, UniversityRequest request) {
        if (request.getName() != null) university.setName(request.getName());
        if (request.getNameNepali() != null) university.setNameNepali(request.getNameNepali());
        if (request.getSlug() != null) university.setSlug(request.getSlug());
        if (request.getCode() != null) university.setCode(request.getCode());
        if (request.getType() != null) university.setType(request.getType());
        if (request.getEstablishedYear() != null) university.setEstablishedYear(request.getEstablishedYear());
        if (request.getViceChancellor() != null) university.setViceChancellor(request.getViceChancellor());
        if (request.getStudentCount() != null) university.setStudentCount(request.getStudentCount());
        if (request.getFacultyCount() != null) university.setFacultyCount(request.getFacultyCount());
        if (request.getCampusCount() != null) university.setCampusCount(request.getCampusCount());
        if (request.getAffiliatedColleges() != null) university.setAffiliatedColleges(request.getAffiliatedColleges());
        if (request.getFaculties() != null) university.setFaculties(request.getFaculties());
        if (request.getDescription() != null) university.setDescription(request.getDescription());
        if (request.getLatitude() != null) university.setLatitude(request.getLatitude());
        if (request.getLongitude() != null) university.setLongitude(request.getLongitude());
        if (request.getElevation() != null) university.setElevation(request.getElevation());
        if (request.getProvinceId() != null) university.setProvinceId(request.getProvinceId());
        if (request.getProvinceName() != null) university.setProvinceName(request.getProvinceName());
        if (request.getDistrictId() != null) university.setDistrictId(request.getDistrictId());
        if (request.getDistrictName() != null) university.setDistrictName(request.getDistrictName());
        if (request.getMunicipalityId() != null) university.setMunicipalityId(request.getMunicipalityId());
        if (request.getMunicipalityName() != null) university.setMunicipalityName(request.getMunicipalityName());
        if (request.getWardId() != null) university.setWardId(request.getWardId());
        if (request.getWardName() != null) university.setWardName(request.getWardName());
        if (request.getAddress() != null) university.setAddress(request.getAddress());
        if (request.getPhone() != null) university.setPhone(request.getPhone());
        if (request.getEmail() != null) university.setEmail(request.getEmail());
        if (request.getWebsite() != null) university.setWebsite(request.getWebsite());
        if (request.getImageUrl() != null) university.setImageUrl(request.getImageUrl());
    }
}

package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.TeacherProfileRequest;
import com.knownepal.education.dto.response.TeacherProfileResponse;
import com.knownepal.education.model.TeacherProfile;

public final class TeacherProfileMapper {

    private TeacherProfileMapper() {
    }

    public static TeacherProfile toEntity(TeacherProfileRequest request) {
        if (request == null) return null;
        return TeacherProfile.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .slug(request.getSlug())
                .qualificationLevel(request.getQualificationLevel())
                .qualificationDetail(request.getQualificationDetail())
                .specialization(request.getSpecialization())
                .experienceYears(request.getExperienceYears())
                .institutionType(request.getInstitutionType())
                .institutionId(request.getInstitutionId())
                .institutionName(request.getInstitutionName())
                .department(request.getDepartment())
                .designation(request.getDesignation())
                .provinceId(request.getProvinceId())
                .provinceName(request.getProvinceName())
                .districtId(request.getDistrictId())
                .districtName(request.getDistrictName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .bio(request.getBio())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static TeacherProfileResponse toResponse(TeacherProfile teacherProfile) {
        if (teacherProfile == null) return null;
        return new TeacherProfileResponse(
                teacherProfile.getId(), teacherProfile.getName(), teacherProfile.getNameNepali(),
                teacherProfile.getSlug(), teacherProfile.getQualificationLevel(),
                teacherProfile.getQualificationDetail(), teacherProfile.getSpecialization(),
                teacherProfile.getExperienceYears(),
                teacherProfile.getInstitutionType(), teacherProfile.getInstitutionId(),
                teacherProfile.getInstitutionName(), teacherProfile.getDepartment(),
                teacherProfile.getDesignation(),
                teacherProfile.getProvinceId(), teacherProfile.getProvinceName(),
                teacherProfile.getDistrictId(), teacherProfile.getDistrictName(),
                teacherProfile.getPhone(), teacherProfile.getEmail(),
                teacherProfile.getBio(), teacherProfile.getImageUrl(),
                teacherProfile.getCreatedAt(), teacherProfile.getUpdatedAt()
        );
    }

    public static void updateEntity(TeacherProfile teacherProfile, TeacherProfileRequest request) {
        if (request.getName() != null) teacherProfile.setName(request.getName());
        if (request.getNameNepali() != null) teacherProfile.setNameNepali(request.getNameNepali());
        if (request.getSlug() != null) teacherProfile.setSlug(request.getSlug());
        if (request.getQualificationLevel() != null) teacherProfile.setQualificationLevel(request.getQualificationLevel());
        if (request.getQualificationDetail() != null) teacherProfile.setQualificationDetail(request.getQualificationDetail());
        if (request.getSpecialization() != null) teacherProfile.setSpecialization(request.getSpecialization());
        if (request.getExperienceYears() != null) teacherProfile.setExperienceYears(request.getExperienceYears());
        if (request.getInstitutionType() != null) teacherProfile.setInstitutionType(request.getInstitutionType());
        if (request.getInstitutionId() != null) teacherProfile.setInstitutionId(request.getInstitutionId());
        if (request.getInstitutionName() != null) teacherProfile.setInstitutionName(request.getInstitutionName());
        if (request.getDepartment() != null) teacherProfile.setDepartment(request.getDepartment());
        if (request.getDesignation() != null) teacherProfile.setDesignation(request.getDesignation());
        if (request.getProvinceId() != null) teacherProfile.setProvinceId(request.getProvinceId());
        if (request.getProvinceName() != null) teacherProfile.setProvinceName(request.getProvinceName());
        if (request.getDistrictId() != null) teacherProfile.setDistrictId(request.getDistrictId());
        if (request.getDistrictName() != null) teacherProfile.setDistrictName(request.getDistrictName());
        if (request.getPhone() != null) teacherProfile.setPhone(request.getPhone());
        if (request.getEmail() != null) teacherProfile.setEmail(request.getEmail());
        if (request.getBio() != null) teacherProfile.setBio(request.getBio());
        if (request.getImageUrl() != null) teacherProfile.setImageUrl(request.getImageUrl());
    }
}

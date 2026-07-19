package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.ScholarshipRequest;
import com.knownepal.education.dto.response.ScholarshipResponse;
import com.knownepal.education.model.Scholarship;

public final class ScholarshipMapper {

    private ScholarshipMapper() {
    }

    public static Scholarship toEntity(ScholarshipRequest request) {
        if (request == null) return null;
        return Scholarship.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .slug(request.getSlug())
                .type(request.getType())
                .provider(request.getProvider())
                .amount(request.getAmount())
                .eligibility(request.getEligibility())
                .deadline(request.getDeadline())
                .applicationUrl(request.getApplicationUrl())
                .description(request.getDescription())
                .totalSlots(request.getTotalSlots())
                .isRenewable(request.getIsRenewable())
                .provinceId(request.getProvinceId())
                .provinceName(request.getProvinceName())
                .districtId(request.getDistrictId())
                .districtName(request.getDistrictName())
                .contactPhone(request.getContactPhone())
                .contactEmail(request.getContactEmail())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static ScholarshipResponse toResponse(Scholarship scholarship) {
        if (scholarship == null) return null;
        return new ScholarshipResponse(
                scholarship.getId(), scholarship.getName(), scholarship.getNameNepali(),
                scholarship.getSlug(), scholarship.getType(),
                scholarship.getProvider(), scholarship.getAmount(),
                scholarship.getEligibility(), scholarship.getDeadline(),
                scholarship.getApplicationUrl(), scholarship.getDescription(),
                scholarship.getTotalSlots(), scholarship.getIsRenewable(),
                scholarship.getProvinceId(), scholarship.getProvinceName(),
                scholarship.getDistrictId(), scholarship.getDistrictName(),
                scholarship.getContactPhone(), scholarship.getContactEmail(),
                scholarship.getImageUrl(), scholarship.getCreatedAt(), scholarship.getUpdatedAt()
        );
    }

    public static void updateEntity(Scholarship scholarship, ScholarshipRequest request) {
        if (request.getName() != null) scholarship.setName(request.getName());
        if (request.getNameNepali() != null) scholarship.setNameNepali(request.getNameNepali());
        if (request.getSlug() != null) scholarship.setSlug(request.getSlug());
        if (request.getType() != null) scholarship.setType(request.getType());
        if (request.getProvider() != null) scholarship.setProvider(request.getProvider());
        if (request.getAmount() != null) scholarship.setAmount(request.getAmount());
        if (request.getEligibility() != null) scholarship.setEligibility(request.getEligibility());
        if (request.getDeadline() != null) scholarship.setDeadline(request.getDeadline());
        if (request.getApplicationUrl() != null) scholarship.setApplicationUrl(request.getApplicationUrl());
        if (request.getDescription() != null) scholarship.setDescription(request.getDescription());
        if (request.getTotalSlots() != null) scholarship.setTotalSlots(request.getTotalSlots());
        if (request.getIsRenewable() != null) scholarship.setIsRenewable(request.getIsRenewable());
        if (request.getProvinceId() != null) scholarship.setProvinceId(request.getProvinceId());
        if (request.getProvinceName() != null) scholarship.setProvinceName(request.getProvinceName());
        if (request.getDistrictId() != null) scholarship.setDistrictId(request.getDistrictId());
        if (request.getDistrictName() != null) scholarship.setDistrictName(request.getDistrictName());
        if (request.getContactPhone() != null) scholarship.setContactPhone(request.getContactPhone());
        if (request.getContactEmail() != null) scholarship.setContactEmail(request.getContactEmail());
        if (request.getImageUrl() != null) scholarship.setImageUrl(request.getImageUrl());
    }
}

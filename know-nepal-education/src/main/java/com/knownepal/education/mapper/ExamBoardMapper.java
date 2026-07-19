package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.ExamBoardRequest;
import com.knownepal.education.dto.response.ExamBoardResponse;
import com.knownepal.education.model.ExamBoard;

public final class ExamBoardMapper {

    private ExamBoardMapper() {
    }

    public static ExamBoard toEntity(ExamBoardRequest request) {
        if (request == null) return null;
        return ExamBoard.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .slug(request.getSlug())
                .code(request.getCode())
                .category(request.getCategory())
                .establishedYear(request.getEstablishedYear())
                .headquarters(request.getHeadquarters())
                .website(request.getWebsite())
                .description(request.getDescription())
                .gradingSystem(request.getGradingSystem())
                .provinceId(request.getProvinceId())
                .provinceName(request.getProvinceName())
                .districtId(request.getDistrictId())
                .districtName(request.getDistrictName())
                .phone(request.getPhone())
                .email(request.getEmail())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static ExamBoardResponse toResponse(ExamBoard examBoard) {
        if (examBoard == null) return null;
        return new ExamBoardResponse(
                examBoard.getId(), examBoard.getName(), examBoard.getNameNepali(),
                examBoard.getSlug(), examBoard.getCode(), examBoard.getCategory(),
                examBoard.getEstablishedYear(), examBoard.getHeadquarters(),
                examBoard.getWebsite(), examBoard.getDescription(),
                examBoard.getGradingSystem(),
                examBoard.getProvinceId(), examBoard.getProvinceName(),
                examBoard.getDistrictId(), examBoard.getDistrictName(),
                examBoard.getPhone(), examBoard.getEmail(),
                examBoard.getImageUrl(), examBoard.getCreatedAt(), examBoard.getUpdatedAt()
        );
    }

    public static void updateEntity(ExamBoard examBoard, ExamBoardRequest request) {
        if (request.getName() != null) examBoard.setName(request.getName());
        if (request.getNameNepali() != null) examBoard.setNameNepali(request.getNameNepali());
        if (request.getSlug() != null) examBoard.setSlug(request.getSlug());
        if (request.getCode() != null) examBoard.setCode(request.getCode());
        if (request.getCategory() != null) examBoard.setCategory(request.getCategory());
        if (request.getEstablishedYear() != null) examBoard.setEstablishedYear(request.getEstablishedYear());
        if (request.getHeadquarters() != null) examBoard.setHeadquarters(request.getHeadquarters());
        if (request.getWebsite() != null) examBoard.setWebsite(request.getWebsite());
        if (request.getDescription() != null) examBoard.setDescription(request.getDescription());
        if (request.getGradingSystem() != null) examBoard.setGradingSystem(request.getGradingSystem());
        if (request.getProvinceId() != null) examBoard.setProvinceId(request.getProvinceId());
        if (request.getProvinceName() != null) examBoard.setProvinceName(request.getProvinceName());
        if (request.getDistrictId() != null) examBoard.setDistrictId(request.getDistrictId());
        if (request.getDistrictName() != null) examBoard.setDistrictName(request.getDistrictName());
        if (request.getPhone() != null) examBoard.setPhone(request.getPhone());
        if (request.getEmail() != null) examBoard.setEmail(request.getEmail());
        if (request.getImageUrl() != null) examBoard.setImageUrl(request.getImageUrl());
    }
}

package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.FeeBreakdownRequest;
import com.knownepal.education.dto.response.FeeBreakdownResponse;
import com.knownepal.education.model.FeeBreakdown;

public final class FeeBreakdownMapper {

    private FeeBreakdownMapper() {
    }

    public static FeeBreakdown toEntity(FeeBreakdownRequest request) {
        if (request == null) return null;
        return FeeBreakdown.builder()
                .programId(request.getProgramId())
                .programName(request.getProgramName())
                .institutionType(request.getInstitutionType())
                .institutionId(request.getInstitutionId())
                .institutionName(request.getInstitutionName())
                .component(request.getComponent())
                .amount(request.getAmount())
                .currency(request.getCurrency())
                .semester(request.getSemester())
                .academicYear(request.getAcademicYear())
                .description(request.getDescription())
                .build();
    }

    public static FeeBreakdownResponse toResponse(FeeBreakdown feeBreakdown) {
        if (feeBreakdown == null) return null;
        return new FeeBreakdownResponse(
                feeBreakdown.getId(),
                feeBreakdown.getProgramId(), feeBreakdown.getProgramName(),
                feeBreakdown.getInstitutionType(), feeBreakdown.getInstitutionId(),
                feeBreakdown.getInstitutionName(), feeBreakdown.getComponent(),
                feeBreakdown.getAmount(), feeBreakdown.getCurrency(),
                feeBreakdown.getSemester(), feeBreakdown.getAcademicYear(),
                feeBreakdown.getDescription(), feeBreakdown.getCreatedAt(),
                feeBreakdown.getUpdatedAt()
        );
    }

    public static void updateEntity(FeeBreakdown feeBreakdown, FeeBreakdownRequest request) {
        if (request.getProgramId() != null) feeBreakdown.setProgramId(request.getProgramId());
        if (request.getProgramName() != null) feeBreakdown.setProgramName(request.getProgramName());
        if (request.getInstitutionType() != null) feeBreakdown.setInstitutionType(request.getInstitutionType());
        if (request.getInstitutionId() != null) feeBreakdown.setInstitutionId(request.getInstitutionId());
        if (request.getInstitutionName() != null) feeBreakdown.setInstitutionName(request.getInstitutionName());
        if (request.getComponent() != null) feeBreakdown.setComponent(request.getComponent());
        if (request.getAmount() != null) feeBreakdown.setAmount(request.getAmount());
        if (request.getCurrency() != null) feeBreakdown.setCurrency(request.getCurrency());
        if (request.getSemester() != null) feeBreakdown.setSemester(request.getSemester());
        if (request.getAcademicYear() != null) feeBreakdown.setAcademicYear(request.getAcademicYear());
        if (request.getDescription() != null) feeBreakdown.setDescription(request.getDescription());
    }
}

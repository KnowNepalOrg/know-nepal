package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.ProgramRequest;
import com.knownepal.education.dto.response.ProgramResponse;
import com.knownepal.education.model.Program;

public final class ProgramMapper {

    private ProgramMapper() {
    }

    public static Program toEntity(ProgramRequest request) {
        if (request == null) return null;
        return Program.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .slug(request.getSlug())
                .code(request.getCode())
                .level(request.getLevel())
                .faculty(request.getFaculty())
                .durationYears(request.getDurationYears())
                .totalSeats(request.getTotalSeats())
                .feeStructure(request.getFeeStructure())
                .eligibility(request.getEligibility())
                .description(request.getDescription())
                .institutionType(request.getInstitutionType())
                .institutionId(request.getInstitutionId())
                .institutionName(request.getInstitutionName())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static ProgramResponse toResponse(Program program) {
        if (program == null) return null;
        return new ProgramResponse(
                program.getId(), program.getName(), program.getNameNepali(),
                program.getSlug(), program.getCode(), program.getLevel(),
                program.getFaculty(), program.getDurationYears(), program.getTotalSeats(),
                program.getFeeStructure(), program.getEligibility(), program.getDescription(),
                program.getInstitutionType(), program.getInstitutionId(), program.getInstitutionName(),
                program.getImageUrl(), program.getCreatedAt(), program.getUpdatedAt()
        );
    }

    public static void updateEntity(Program program, ProgramRequest request) {
        if (request.getName() != null) program.setName(request.getName());
        if (request.getNameNepali() != null) program.setNameNepali(request.getNameNepali());
        if (request.getSlug() != null) program.setSlug(request.getSlug());
        if (request.getCode() != null) program.setCode(request.getCode());
        if (request.getLevel() != null) program.setLevel(request.getLevel());
        if (request.getFaculty() != null) program.setFaculty(request.getFaculty());
        if (request.getDurationYears() != null) program.setDurationYears(request.getDurationYears());
        if (request.getTotalSeats() != null) program.setTotalSeats(request.getTotalSeats());
        if (request.getFeeStructure() != null) program.setFeeStructure(request.getFeeStructure());
        if (request.getEligibility() != null) program.setEligibility(request.getEligibility());
        if (request.getDescription() != null) program.setDescription(request.getDescription());
        if (request.getInstitutionType() != null) program.setInstitutionType(request.getInstitutionType());
        if (request.getInstitutionId() != null) program.setInstitutionId(request.getInstitutionId());
        if (request.getInstitutionName() != null) program.setInstitutionName(request.getInstitutionName());
        if (request.getImageUrl() != null) program.setImageUrl(request.getImageUrl());
    }
}

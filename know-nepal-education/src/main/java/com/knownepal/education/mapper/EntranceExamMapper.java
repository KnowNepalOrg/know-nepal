package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.EntranceExamRequest;
import com.knownepal.education.dto.response.EntranceExamResponse;
import com.knownepal.education.model.EntranceExam;

public final class EntranceExamMapper {

    private EntranceExamMapper() {
    }

    public static EntranceExam toEntity(EntranceExamRequest request) {
        if (request == null) return null;
        return EntranceExam.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .slug(request.getSlug())
                .code(request.getCode())
                .boardId(request.getBoardId())
                .boardName(request.getBoardName())
                .format(request.getFormat())
                .examDate(request.getExamDate())
                .registrationDeadline(request.getRegistrationDeadline())
                .eligibility(request.getEligibility())
                .syllabus(request.getSyllabus())
                .feeStructure(request.getFeeStructure())
                .totalSeats(request.getTotalSeats())
                .durationHours(request.getDurationHours())
                .totalMarks(request.getTotalMarks())
                .passMarks(request.getPassMarks())
                .description(request.getDescription())
                .website(request.getWebsite())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static EntranceExamResponse toResponse(EntranceExam entranceExam) {
        if (entranceExam == null) return null;
        return new EntranceExamResponse(
                entranceExam.getId(), entranceExam.getName(), entranceExam.getNameNepali(),
                entranceExam.getSlug(), entranceExam.getCode(),
                entranceExam.getBoardId(), entranceExam.getBoardName(),
                entranceExam.getFormat(), entranceExam.getExamDate(),
                entranceExam.getRegistrationDeadline(), entranceExam.getEligibility(),
                entranceExam.getSyllabus(), entranceExam.getFeeStructure(),
                entranceExam.getTotalSeats(), entranceExam.getDurationHours(),
                entranceExam.getTotalMarks(), entranceExam.getPassMarks(),
                entranceExam.getDescription(), entranceExam.getWebsite(),
                entranceExam.getImageUrl(), entranceExam.getCreatedAt(), entranceExam.getUpdatedAt()
        );
    }

    public static void updateEntity(EntranceExam entranceExam, EntranceExamRequest request) {
        if (request.getName() != null) entranceExam.setName(request.getName());
        if (request.getNameNepali() != null) entranceExam.setNameNepali(request.getNameNepali());
        if (request.getSlug() != null) entranceExam.setSlug(request.getSlug());
        if (request.getCode() != null) entranceExam.setCode(request.getCode());
        if (request.getBoardId() != null) entranceExam.setBoardId(request.getBoardId());
        if (request.getBoardName() != null) entranceExam.setBoardName(request.getBoardName());
        if (request.getFormat() != null) entranceExam.setFormat(request.getFormat());
        if (request.getExamDate() != null) entranceExam.setExamDate(request.getExamDate());
        if (request.getRegistrationDeadline() != null) entranceExam.setRegistrationDeadline(request.getRegistrationDeadline());
        if (request.getEligibility() != null) entranceExam.setEligibility(request.getEligibility());
        if (request.getSyllabus() != null) entranceExam.setSyllabus(request.getSyllabus());
        if (request.getFeeStructure() != null) entranceExam.setFeeStructure(request.getFeeStructure());
        if (request.getTotalSeats() != null) entranceExam.setTotalSeats(request.getTotalSeats());
        if (request.getDurationHours() != null) entranceExam.setDurationHours(request.getDurationHours());
        if (request.getTotalMarks() != null) entranceExam.setTotalMarks(request.getTotalMarks());
        if (request.getPassMarks() != null) entranceExam.setPassMarks(request.getPassMarks());
        if (request.getDescription() != null) entranceExam.setDescription(request.getDescription());
        if (request.getWebsite() != null) entranceExam.setWebsite(request.getWebsite());
        if (request.getImageUrl() != null) entranceExam.setImageUrl(request.getImageUrl());
    }
}

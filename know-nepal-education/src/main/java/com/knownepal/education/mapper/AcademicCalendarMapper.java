package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.AcademicCalendarRequest;
import com.knownepal.education.dto.response.AcademicCalendarResponse;
import com.knownepal.education.model.AcademicCalendar;

public final class AcademicCalendarMapper {

    private AcademicCalendarMapper() {
    }

    public static AcademicCalendar toEntity(AcademicCalendarRequest request) {
        if (request == null) return null;
        return AcademicCalendar.builder()
                .institutionType(request.getInstitutionType())
                .institutionId(request.getInstitutionId())
                .institutionName(request.getInstitutionName())
                .eventTitle(request.getEventTitle())
                .eventDescription(request.getEventDescription())
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .academicYear(request.getAcademicYear())
                .semester(request.getSemester())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static AcademicCalendarResponse toResponse(AcademicCalendar academicCalendar) {
        if (academicCalendar == null) return null;
        return new AcademicCalendarResponse(
                academicCalendar.getId(),
                academicCalendar.getInstitutionType(), academicCalendar.getInstitutionId(),
                academicCalendar.getInstitutionName(), academicCalendar.getEventTitle(),
                academicCalendar.getEventDescription(), academicCalendar.getStartDate(),
                academicCalendar.getEndDate(), academicCalendar.getAcademicYear(),
                academicCalendar.getSemester(), academicCalendar.getImageUrl(),
                academicCalendar.getCreatedAt(), academicCalendar.getUpdatedAt()
        );
    }

    public static void updateEntity(AcademicCalendar academicCalendar, AcademicCalendarRequest request) {
        if (request.getInstitutionType() != null) academicCalendar.setInstitutionType(request.getInstitutionType());
        if (request.getInstitutionId() != null) academicCalendar.setInstitutionId(request.getInstitutionId());
        if (request.getInstitutionName() != null) academicCalendar.setInstitutionName(request.getInstitutionName());
        if (request.getEventTitle() != null) academicCalendar.setEventTitle(request.getEventTitle());
        if (request.getEventDescription() != null) academicCalendar.setEventDescription(request.getEventDescription());
        if (request.getStartDate() != null) academicCalendar.setStartDate(request.getStartDate());
        if (request.getEndDate() != null) academicCalendar.setEndDate(request.getEndDate());
        if (request.getAcademicYear() != null) academicCalendar.setAcademicYear(request.getAcademicYear());
        if (request.getSemester() != null) academicCalendar.setSemester(request.getSemester());
        if (request.getImageUrl() != null) academicCalendar.setImageUrl(request.getImageUrl());
    }
}

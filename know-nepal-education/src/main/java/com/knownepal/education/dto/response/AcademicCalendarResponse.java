package com.knownepal.education.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Academic calendar response")
public record AcademicCalendarResponse(
        Long id,
        String institutionType,
        Long institutionId,
        String institutionName,
        String eventTitle,
        String eventDescription,
        String startDate,
        String endDate,
        String academicYear,
        String semester,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

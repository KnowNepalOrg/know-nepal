package com.knownepal.education.dto.response;

import com.knownepal.education.model.InstitutionType;
import com.knownepal.education.model.ProgramLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Program response")
public record ProgramResponse(
        Long id,
        String name,
        String nameNepali,
        String slug,
        String code,
        ProgramLevel level,
        String faculty,
        Integer durationYears,
        Integer totalSeats,
        String feeStructure,
        String eligibility,
        String description,
        InstitutionType institutionType,
        Long institutionId,
        String institutionName,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

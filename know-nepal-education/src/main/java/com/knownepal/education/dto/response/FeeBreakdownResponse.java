package com.knownepal.education.dto.response;

import com.knownepal.education.model.FeeComponent;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Fee breakdown response")
public record FeeBreakdownResponse(
        Long id,
        Long programId,
        String programName,
        String institutionType,
        Long institutionId,
        String institutionName,
        FeeComponent component,
        Double amount,
        String currency,
        String semester,
        String academicYear,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

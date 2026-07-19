package com.knownepal.education.dto.response;

import com.knownepal.education.model.BoardCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Exam board response")
public record ExamBoardResponse(
        Long id,
        String name,
        String nameNepali,
        String slug,
        String code,
        BoardCategory category,
        Integer establishedYear,
        String headquarters,
        String website,
        String description,
        String gradingSystem,
        Long provinceId,
        String provinceName,
        Long districtId,
        String districtName,
        String phone,
        String email,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

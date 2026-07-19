package com.knownepal.education.dto.response;

import com.knownepal.education.model.QualificationLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Teacher profile response")
public record TeacherProfileResponse(
        Long id,
        String name,
        String nameNepali,
        String slug,
        QualificationLevel qualificationLevel,
        String qualificationDetail,
        String specialization,
        Integer experienceYears,
        String institutionType,
        Long institutionId,
        String institutionName,
        String department,
        String designation,
        Long provinceId,
        String provinceName,
        Long districtId,
        String districtName,
        String phone,
        String email,
        String bio,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

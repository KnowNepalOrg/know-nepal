package com.knownepal.education.dto.response;

import com.knownepal.education.model.EducationLevel;
import com.knownepal.education.model.SchoolType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "School response")
public record SchoolResponse(
        Long id,
        String name,
        String nameNepali,
        String slug,
        String code,
        SchoolType type,
        EducationLevel level,
        Integer establishedYear,
        String affiliation,
        Integer studentCount,
        Integer teacherCount,
        Double areaSqKm,
        String description,
        Double latitude,
        Double longitude,
        Double elevation,
        Long provinceId,
        String provinceName,
        Long districtId,
        String districtName,
        Long municipalityId,
        String municipalityName,
        Long wardId,
        String wardName,
        String address,
        String phone,
        String email,
        String website,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

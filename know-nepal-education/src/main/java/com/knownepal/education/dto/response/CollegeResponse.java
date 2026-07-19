package com.knownepal.education.dto.response;

import com.knownepal.education.model.CollegeLevel;
import com.knownepal.education.model.CollegeType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "College response")
public record CollegeResponse(
        Long id,
        String name,
        String nameNepali,
        String slug,
        String code,
        CollegeType type,
        CollegeLevel level,
        Integer establishedYear,
        String affiliation,
        Integer studentCount,
        Integer teacherCount,
        String facilities,
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

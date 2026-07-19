package com.knownepal.education.dto.response;

import com.knownepal.education.model.UniversityType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "University response")
public record UniversityResponse(
        Long id,
        String name,
        String nameNepali,
        String slug,
        String code,
        UniversityType type,
        Integer establishedYear,
        String viceChancellor,
        Integer studentCount,
        Integer facultyCount,
        Integer campusCount,
        Integer affiliatedColleges,
        String faculties,
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

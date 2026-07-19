package com.knownepal.education.dto.response;

import com.knownepal.education.model.ScholarshipType;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Scholarship response")
public record ScholarshipResponse(
        Long id,
        String name,
        String nameNepali,
        String slug,
        ScholarshipType type,
        String provider,
        String amount,
        String eligibility,
        String deadline,
        String applicationUrl,
        String description,
        Integer totalSlots,
        Boolean isRenewable,
        Long provinceId,
        String provinceName,
        Long districtId,
        String districtName,
        String contactPhone,
        String contactEmail,
        String imageUrl,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

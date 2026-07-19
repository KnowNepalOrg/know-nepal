package com.knownepal.education.dto.response;

import com.knownepal.education.model.RankingSource;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Ranking response")
public record RankingResponse(
        Long id,
        String institutionType,
        Long institutionId,
        String institutionName,
        RankingSource source,
        Integer rankPosition,
        Double score,
        String category,
        String year,
        String description,
        String website,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}

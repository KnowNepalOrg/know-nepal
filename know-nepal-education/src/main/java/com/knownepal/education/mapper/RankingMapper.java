package com.knownepal.education.mapper;

import com.knownepal.education.dto.request.RankingRequest;
import com.knownepal.education.dto.response.RankingResponse;
import com.knownepal.education.model.Ranking;

public final class RankingMapper {

    private RankingMapper() {
    }

    public static Ranking toEntity(RankingRequest request) {
        if (request == null) return null;
        return Ranking.builder()
                .institutionType(request.getInstitutionType())
                .institutionId(request.getInstitutionId())
                .institutionName(request.getInstitutionName())
                .source(request.getSource())
                .rankPosition(request.getRankPosition())
                .score(request.getScore())
                .category(request.getCategory())
                .year(request.getYear())
                .description(request.getDescription())
                .website(request.getWebsite())
                .build();
    }

    public static RankingResponse toResponse(Ranking ranking) {
        if (ranking == null) return null;
        return new RankingResponse(
                ranking.getId(),
                ranking.getInstitutionType(), ranking.getInstitutionId(),
                ranking.getInstitutionName(), ranking.getSource(),
                ranking.getRankPosition(), ranking.getScore(),
                ranking.getCategory(), ranking.getYear(),
                ranking.getDescription(), ranking.getWebsite(),
                ranking.getCreatedAt(), ranking.getUpdatedAt()
        );
    }

    public static void updateEntity(Ranking ranking, RankingRequest request) {
        if (request.getInstitutionType() != null) ranking.setInstitutionType(request.getInstitutionType());
        if (request.getInstitutionId() != null) ranking.setInstitutionId(request.getInstitutionId());
        if (request.getInstitutionName() != null) ranking.setInstitutionName(request.getInstitutionName());
        if (request.getSource() != null) ranking.setSource(request.getSource());
        if (request.getRankPosition() != null) ranking.setRankPosition(request.getRankPosition());
        if (request.getScore() != null) ranking.setScore(request.getScore());
        if (request.getCategory() != null) ranking.setCategory(request.getCategory());
        if (request.getYear() != null) ranking.setYear(request.getYear());
        if (request.getDescription() != null) ranking.setDescription(request.getDescription());
        if (request.getWebsite() != null) ranking.setWebsite(request.getWebsite());
    }
}

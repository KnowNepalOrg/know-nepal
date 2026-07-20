package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.DestinationReviewResponse;
import com.knownepal.destinations.model.DestinationReview;

public class DestinationReviewMapper {

    private DestinationReviewMapper() {
    }

    public static DestinationReviewResponse toResponse(DestinationReview entity) {
        DestinationReviewResponse response = new DestinationReviewResponse();
        response.setId(entity.getId());
        response.setReviewerName(entity.getReviewerName());
        response.setRating(entity.getRating());
        response.setTitle(entity.getTitle());
        response.setContent(entity.getContent());
        response.setVisitDate(entity.getVisitDate());
        response.setIsVerified(entity.getIsVerified());
        response.setCreatedAt(entity.getCreatedAt());
        if (entity.getDestination() != null) {
            response.setDestinationId(entity.getDestination().getId());
        }
        return response;
    }
}

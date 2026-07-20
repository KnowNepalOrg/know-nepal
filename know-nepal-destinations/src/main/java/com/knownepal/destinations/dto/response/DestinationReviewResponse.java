package com.knownepal.destinations.dto.response;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class DestinationReviewResponse {

    private Long id;
    private Long destinationId;
    private String reviewerName;
    private int rating;
    private String title;
    private String content;
    private LocalDate visitDate;
    private Boolean isVerified;
    private LocalDateTime createdAt;
}

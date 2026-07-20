package com.knownepal.destinations.dto.request;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DestinationReviewRequest {

    @NotBlank(message = "Reviewer name is required")
    private String reviewerName;

    @Min(value = 1, message = "Rating must be between 1 and 5")
    @Max(value = 5, message = "Rating must be between 1 and 5")
    private int rating;

    private String title;
    private String content;
    private LocalDate visitDate;
}

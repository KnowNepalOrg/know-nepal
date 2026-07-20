package com.knownepal.destinations.dto.response;

import lombok.Data;

@Data
public class ItineraryDayDestinationResponse {

    private Long id;
    private Long destinationId;
    private String destinationName;
    private String destinationSlug;
    private Integer sequenceOrder;
    private String notes;
}

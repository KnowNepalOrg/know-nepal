package com.knownepal.destinations.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ItineraryDayDestinationRequest {

    @NotNull(message = "Destination ID is required")
    private Long destinationId;

    @NotNull(message = "Sequence order is required")
    private Integer sequenceOrder;

    private String notes;
}

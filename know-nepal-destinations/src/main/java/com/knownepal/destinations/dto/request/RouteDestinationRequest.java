package com.knownepal.destinations.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RouteDestinationRequest {

    @NotNull(message = "Destination ID is required")
    private Long destinationId;

    @NotNull(message = "Sequence order is required")
    private Integer sequenceOrder;

    private Boolean isOvernightStop;
}

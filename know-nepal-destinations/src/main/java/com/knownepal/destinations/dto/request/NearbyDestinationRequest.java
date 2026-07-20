package com.knownepal.destinations.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class NearbyDestinationRequest {

    @NotNull(message = "Nearby destination ID is required")
    private Long nearbyDestinationId;

    private java.math.BigDecimal distanceKm;
    private Integer travelTimeMinutes;
    private com.knownepal.destinations.model.TravelMode travelMode;
}

package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.TravelMode;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class NearbyDestinationResponse {

    private Long id;
    private Long destinationId;
    private Long nearbyDestinationId;
    private String nearbyDestinationName;
    private String nearbyDestinationSlug;
    private BigDecimal distanceKm;
    private Integer travelTimeMinutes;
    private TravelMode travelMode;
}

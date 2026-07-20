package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.Meals;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class ItineraryDayResponse {

    private Long id;
    private Long itineraryId;
    private Integer dayNumber;
    private String title;
    private String description;
    private String accommodation;
    private Meals meals;
    private BigDecimal distanceKm;
    private List<ItineraryDayDestinationResponse> dayDestinations;
}

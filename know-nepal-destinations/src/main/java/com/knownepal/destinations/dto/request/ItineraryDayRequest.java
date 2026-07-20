package com.knownepal.destinations.dto.request;

import com.knownepal.destinations.model.Meals;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ItineraryDayRequest {

    @NotNull(message = "Day number is required")
    private Integer dayNumber;

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private String accommodation;
    private Meals meals;
    private BigDecimal distanceKm;
}

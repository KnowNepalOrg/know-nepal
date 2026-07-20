package com.knownepal.destinations.dto.request;

import com.knownepal.destinations.model.WeatherSeason;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DestinationWeatherRequest {

    @NotNull(message = "Weather season is required")
    private WeatherSeason weatherSeason;

    private BigDecimal avgTempCelsius;
    private BigDecimal minTempCelsius;
    private BigDecimal maxTempCelsius;
    private BigDecimal rainfallMm;
    private String conditions;
    private Boolean isRecommended;
}

package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.WeatherSeason;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DestinationWeatherResponse {

    private Long id;
    private Long destinationId;
    private WeatherSeason weatherSeason;
    private BigDecimal avgTempCelsius;
    private BigDecimal minTempCelsius;
    private BigDecimal maxTempCelsius;
    private BigDecimal rainfallMm;
    private String conditions;
    private Boolean isRecommended;
}

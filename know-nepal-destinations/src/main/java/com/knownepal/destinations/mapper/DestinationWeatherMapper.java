package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.DestinationWeatherResponse;
import com.knownepal.destinations.model.DestinationWeather;

public class DestinationWeatherMapper {

    private DestinationWeatherMapper() {
    }

    public static DestinationWeatherResponse toResponse(DestinationWeather entity) {
        DestinationWeatherResponse response = new DestinationWeatherResponse();
        response.setId(entity.getId());
        response.setWeatherSeason(entity.getWeatherSeason());
        response.setAvgTempCelsius(entity.getAvgTempCelsius());
        response.setMinTempCelsius(entity.getMinTempCelsius());
        response.setMaxTempCelsius(entity.getMaxTempCelsius());
        response.setRainfallMm(entity.getRainfallMm());
        response.setConditions(entity.getConditions());
        response.setIsRecommended(entity.getIsRecommended());
        if (entity.getDestination() != null) {
            response.setDestinationId(entity.getDestination().getId());
        }
        return response;
    }
}

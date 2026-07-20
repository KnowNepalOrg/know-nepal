package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.TrekkingRouteResponse;
import com.knownepal.destinations.model.TrekkingRoute;

import java.util.stream.Collectors;

public class TrekkingRouteMapper {

    private TrekkingRouteMapper() {
    }

    public static TrekkingRouteResponse toResponse(TrekkingRoute entity) {
        TrekkingRouteResponse response = new TrekkingRouteResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setDifficultyLevel(entity.getDifficultyLevel());
        response.setDistanceKm(entity.getDistanceKm());
        response.setDurationDays(entity.getDurationDays());
        response.setMaxAltitudeMeters(entity.getMaxAltitudeMeters());
        response.setBestSeason(entity.getBestSeason());
        response.setIsPopular(entity.getIsPopular());
        if (entity.getRouteDestinations() != null) {
            response.setRouteDestinations(
                    entity.getRouteDestinations().stream()
                            .map(RouteDestinationMapper::toResponse)
                            .collect(Collectors.toList())
            );
        }
        return response;
    }
}

package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.RouteDestinationRequest;
import com.knownepal.destinations.dto.response.RouteDestinationResponse;

import java.util.List;

public interface RouteDestinationService {
    List<RouteDestinationResponse> findByRouteId(Long routeId);
    RouteDestinationResponse create(Long routeId, RouteDestinationRequest request);
    void delete(Long id);
}

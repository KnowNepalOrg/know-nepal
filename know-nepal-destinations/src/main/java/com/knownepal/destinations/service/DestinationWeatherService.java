package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.DestinationWeatherRequest;
import com.knownepal.destinations.dto.response.DestinationWeatherResponse;

import java.util.List;

public interface DestinationWeatherService {
    List<DestinationWeatherResponse> findByDestinationId(Long destinationId);
    DestinationWeatherResponse create(Long destinationId, DestinationWeatherRequest request);
    DestinationWeatherResponse update(Long id, DestinationWeatherRequest request);
    void delete(Long id);
}

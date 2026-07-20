package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.ItineraryDayDestinationRequest;
import com.knownepal.destinations.dto.response.ItineraryDayDestinationResponse;

import java.util.List;

public interface ItineraryDayDestinationService {
    List<ItineraryDayDestinationResponse> findByDayId(Long dayId);
    ItineraryDayDestinationResponse create(Long dayId, ItineraryDayDestinationRequest request);
    void delete(Long id);
}

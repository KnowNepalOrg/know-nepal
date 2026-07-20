package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.ItineraryDayRequest;
import com.knownepal.destinations.dto.response.ItineraryDayResponse;

import java.util.List;

public interface ItineraryDayService {
    List<ItineraryDayResponse> findByItineraryId(Long itineraryId);
    ItineraryDayResponse findById(Long id);
    ItineraryDayResponse create(Long itineraryId, ItineraryDayRequest request);
    ItineraryDayResponse update(Long id, ItineraryDayRequest request);
    void delete(Long id);
}

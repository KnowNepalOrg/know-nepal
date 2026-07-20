package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.DestinationItineraryRequest;
import com.knownepal.destinations.dto.response.DestinationItineraryResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DestinationItineraryService {
    List<DestinationItineraryResponse> findAll(Pageable pageable);
    DestinationItineraryResponse findById(Long id);
    DestinationItineraryResponse findBySlug(String slug);
    DestinationItineraryResponse create(DestinationItineraryRequest request);
    DestinationItineraryResponse update(Long id, DestinationItineraryRequest request);
    void delete(Long id);
    long count();
}

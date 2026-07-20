package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.TouristDestinationRequest;
import com.knownepal.destinations.dto.response.TouristDestinationResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface TouristDestinationService {
    List<TouristDestinationResponse> findAll(Pageable pageable);
    TouristDestinationResponse findById(Long id);
    TouristDestinationResponse findBySlug(String slug);
    TouristDestinationResponse create(TouristDestinationRequest request);
    TouristDestinationResponse update(Long id, TouristDestinationRequest request);
    void delete(Long id);
    List<TouristDestinationResponse> search(String query, Pageable pageable);
    List<TouristDestinationResponse> findByFilters(Map<String, String> filters, Pageable pageable);
    long count();
}

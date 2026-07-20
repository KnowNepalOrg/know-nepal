package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.DestinationHighlightRequest;
import com.knownepal.destinations.dto.response.DestinationHighlightResponse;

import java.util.List;

public interface DestinationHighlightService {
    List<DestinationHighlightResponse> findByDestinationId(Long destinationId);
    DestinationHighlightResponse findById(Long id);
    DestinationHighlightResponse create(Long destinationId, DestinationHighlightRequest request);
    DestinationHighlightResponse update(Long id, DestinationHighlightRequest request);
    void delete(Long id);
}

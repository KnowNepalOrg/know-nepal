package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.NearbyDestinationRequest;
import com.knownepal.destinations.dto.response.NearbyDestinationResponse;

import java.util.List;

public interface NearbyDestinationService {
    List<NearbyDestinationResponse> findByDestinationId(Long destinationId);
    NearbyDestinationResponse create(Long destinationId, NearbyDestinationRequest request);
    void delete(Long id);
}

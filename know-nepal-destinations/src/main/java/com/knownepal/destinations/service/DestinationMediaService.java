package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.DestinationMediaRequest;
import com.knownepal.destinations.dto.response.DestinationMediaResponse;

import java.util.List;

public interface DestinationMediaService {
    List<DestinationMediaResponse> findByDestinationId(Long destinationId);
    DestinationMediaResponse findById(Long id);
    DestinationMediaResponse create(Long destinationId, DestinationMediaRequest request);
    DestinationMediaResponse update(Long id, DestinationMediaRequest request);
    void delete(Long id);
}

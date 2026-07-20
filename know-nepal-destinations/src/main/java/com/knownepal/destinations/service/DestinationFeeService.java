package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.DestinationFeeRequest;
import com.knownepal.destinations.dto.response.DestinationFeeResponse;

import java.util.List;

public interface DestinationFeeService {
    List<DestinationFeeResponse> findByDestinationId(Long destinationId);
    DestinationFeeResponse findById(Long id);
    DestinationFeeResponse create(Long destinationId, DestinationFeeRequest request);
    DestinationFeeResponse update(Long id, DestinationFeeRequest request);
    void delete(Long id);
}

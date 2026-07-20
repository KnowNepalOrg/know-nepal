package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.DestinationReviewRequest;
import com.knownepal.destinations.dto.response.DestinationReviewResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DestinationReviewService {
    List<DestinationReviewResponse> findByDestinationId(Long destinationId, Pageable pageable);
    DestinationReviewResponse findById(Long id);
    DestinationReviewResponse create(Long destinationId, DestinationReviewRequest request);
    DestinationReviewResponse update(Long id, DestinationReviewRequest request);
    void delete(Long id);
}

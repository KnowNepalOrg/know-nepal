package com.knownepal.history.service;

import com.knownepal.history.dto.request.HistoricalEventRequest;
import com.knownepal.history.dto.response.HistoricalEventResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface HistoricalEventService {
    List<HistoricalEventResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<HistoricalEventResponse> search(String query, Pageable pageable);
    HistoricalEventResponse findById(Long id);
    HistoricalEventResponse findBySlug(String slug);
    HistoricalEventResponse create(HistoricalEventRequest request);
    HistoricalEventResponse update(Long id, HistoricalEventRequest request);
    void delete(Long id);
}

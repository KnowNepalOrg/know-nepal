package com.knownepal.history.service;

import com.knownepal.history.dto.request.HistoricalEraRequest;
import com.knownepal.history.dto.response.HistoricalEraResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface HistoricalEraService {
    List<HistoricalEraResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<HistoricalEraResponse> search(String query, Pageable pageable);
    HistoricalEraResponse findById(Long id);
    HistoricalEraResponse findBySlug(String slug);
    HistoricalEraResponse create(HistoricalEraRequest request);
    HistoricalEraResponse update(Long id, HistoricalEraRequest request);
    void delete(Long id);
}

package com.knownepal.history.service;

import com.knownepal.history.dto.request.HistoricalFigureRequest;
import com.knownepal.history.dto.response.HistoricalFigureResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface HistoricalFigureService {
    List<HistoricalFigureResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<HistoricalFigureResponse> search(String query, Pageable pageable);
    HistoricalFigureResponse findById(Long id);
    HistoricalFigureResponse findBySlug(String slug);
    HistoricalFigureResponse create(HistoricalFigureRequest request);
    HistoricalFigureResponse update(Long id, HistoricalFigureRequest request);
    void delete(Long id);
}

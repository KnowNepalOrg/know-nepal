package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.TrekkingRouteRequest;
import com.knownepal.destinations.dto.response.TrekkingRouteResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface TrekkingRouteService {
    List<TrekkingRouteResponse> findAll(Pageable pageable);
    TrekkingRouteResponse findById(Long id);
    TrekkingRouteResponse findBySlug(String slug);
    TrekkingRouteResponse create(TrekkingRouteRequest request);
    TrekkingRouteResponse update(Long id, TrekkingRouteRequest request);
    void delete(Long id);
    List<TrekkingRouteResponse> search(String query, Pageable pageable);
    List<TrekkingRouteResponse> findByFilters(Map<String, String> filters, Pageable pageable);
    long count();
}

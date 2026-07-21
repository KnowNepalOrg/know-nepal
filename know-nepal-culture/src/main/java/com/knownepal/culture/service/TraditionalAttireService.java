package com.knownepal.culture.service;

import com.knownepal.culture.dto.request.TraditionalAttireRequest;
import com.knownepal.culture.dto.response.TraditionalAttireResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface TraditionalAttireService {
    List<TraditionalAttireResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<TraditionalAttireResponse> search(String query, Pageable pageable);
    TraditionalAttireResponse findById(Long id);
    TraditionalAttireResponse findBySlug(String slug);
    TraditionalAttireResponse create(TraditionalAttireRequest request);
    TraditionalAttireResponse update(Long id, TraditionalAttireRequest request);
    void delete(Long id);
}

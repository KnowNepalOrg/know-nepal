package com.knownepal.wildlife.service;

import com.knownepal.wildlife.dto.request.FloraSpeciesRequest;
import com.knownepal.wildlife.dto.response.FloraSpeciesResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface FloraSpeciesService {
    List<FloraSpeciesResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<FloraSpeciesResponse> search(String query, Pageable pageable);
    FloraSpeciesResponse findById(Long id);
    FloraSpeciesResponse findBySlug(String slug);
    FloraSpeciesResponse create(FloraSpeciesRequest request);
    FloraSpeciesResponse update(Long id, FloraSpeciesRequest request);
    void delete(Long id);
}

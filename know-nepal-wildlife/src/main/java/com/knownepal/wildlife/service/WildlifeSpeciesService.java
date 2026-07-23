package com.knownepal.wildlife.service;

import com.knownepal.wildlife.dto.request.WildlifeSpeciesRequest;
import com.knownepal.wildlife.dto.response.WildlifeSpeciesResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface WildlifeSpeciesService {
    List<WildlifeSpeciesResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<WildlifeSpeciesResponse> search(String query, Pageable pageable);
    WildlifeSpeciesResponse findById(Long id);
    WildlifeSpeciesResponse findBySlug(String slug);
    WildlifeSpeciesResponse create(WildlifeSpeciesRequest request);
    WildlifeSpeciesResponse update(Long id, WildlifeSpeciesRequest request);
    void delete(Long id);
}

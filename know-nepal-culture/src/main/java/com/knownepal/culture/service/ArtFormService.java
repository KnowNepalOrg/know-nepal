package com.knownepal.culture.service;

import com.knownepal.culture.dto.request.ArtFormRequest;
import com.knownepal.culture.dto.response.ArtFormResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface ArtFormService {
    List<ArtFormResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<ArtFormResponse> search(String query, Pageable pageable);
    ArtFormResponse findById(Long id);
    ArtFormResponse findBySlug(String slug);
    ArtFormResponse create(ArtFormRequest request);
    ArtFormResponse update(Long id, ArtFormRequest request);
    void delete(Long id);
}

package com.knownepal.culture.service;

import com.knownepal.culture.dto.request.LanguageRequest;
import com.knownepal.culture.dto.response.LanguageResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface LanguageService {
    List<LanguageResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<LanguageResponse> search(String query, Pageable pageable);
    LanguageResponse findById(Long id);
    LanguageResponse findBySlug(String slug);
    LanguageResponse create(LanguageRequest request);
    LanguageResponse update(Long id, LanguageRequest request);
    void delete(Long id);
}

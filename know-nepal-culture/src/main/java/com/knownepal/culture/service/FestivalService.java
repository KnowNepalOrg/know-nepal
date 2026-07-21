package com.knownepal.culture.service;

import com.knownepal.culture.dto.request.FestivalRequest;
import com.knownepal.culture.dto.response.FestivalResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface FestivalService {
    List<FestivalResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<FestivalResponse> search(String query, Pageable pageable);
    FestivalResponse findById(Long id);
    FestivalResponse findBySlug(String slug);
    FestivalResponse create(FestivalRequest request);
    FestivalResponse update(Long id, FestivalRequest request);
    void delete(Long id);
}

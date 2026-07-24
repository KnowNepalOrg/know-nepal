package com.knownepal.history.service;

import com.knownepal.history.dto.request.DynastyRequest;
import com.knownepal.history.dto.response.DynastyResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface DynastyService {
    List<DynastyResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<DynastyResponse> search(String query, Pageable pageable);
    DynastyResponse findById(Long id);
    DynastyResponse findBySlug(String slug);
    DynastyResponse create(DynastyRequest request);
    DynastyResponse update(Long id, DynastyRequest request);
    void delete(Long id);
}

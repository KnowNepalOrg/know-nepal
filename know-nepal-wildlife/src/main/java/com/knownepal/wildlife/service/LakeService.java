package com.knownepal.wildlife.service;

import com.knownepal.wildlife.dto.request.LakeRequest;
import com.knownepal.wildlife.dto.response.LakeResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface LakeService {
    List<LakeResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<LakeResponse> search(String query, Pageable pageable);
    LakeResponse findById(Long id);
    LakeResponse findBySlug(String slug);
    LakeResponse create(LakeRequest request);
    LakeResponse update(Long id, LakeRequest request);
    void delete(Long id);
}

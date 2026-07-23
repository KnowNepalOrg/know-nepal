package com.knownepal.wildlife.service;

import com.knownepal.wildlife.dto.request.NationalParkRequest;
import com.knownepal.wildlife.dto.response.NationalParkResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface NationalParkService {
    List<NationalParkResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<NationalParkResponse> search(String query, Pageable pageable);
    NationalParkResponse findById(Long id);
    NationalParkResponse findBySlug(String slug);
    NationalParkResponse create(NationalParkRequest request);
    NationalParkResponse update(Long id, NationalParkRequest request);
    void delete(Long id);
}

package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.DestinationCategoryRequest;
import com.knownepal.destinations.dto.response.DestinationCategoryResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DestinationCategoryService {
    List<DestinationCategoryResponse> findAll(Pageable pageable);
    DestinationCategoryResponse findById(Long id);
    DestinationCategoryResponse findBySlug(String slug);
    DestinationCategoryResponse create(DestinationCategoryRequest request);
    DestinationCategoryResponse update(Long id, DestinationCategoryRequest request);
    void delete(Long id);
    long count();
}

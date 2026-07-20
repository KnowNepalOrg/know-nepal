package com.knownepal.destinations.service;

import com.knownepal.destinations.dto.request.DestinationTagRequest;
import com.knownepal.destinations.dto.response.TagResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DestinationTagService {
    List<TagResponse> findAll(Pageable pageable);
    TagResponse findById(Long id);
    TagResponse findBySlug(String slug);
    TagResponse create(DestinationTagRequest request);
    TagResponse update(Long id, DestinationTagRequest request);
    void delete(Long id);
}

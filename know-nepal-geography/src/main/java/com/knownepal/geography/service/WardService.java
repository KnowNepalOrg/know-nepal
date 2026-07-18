package com.knownepal.geography.service;

import com.knownepal.geography.dto.request.WardRequest;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.WardResponse;
import com.knownepal.geography.model.Ward;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface WardService {

    PagedResponse<WardResponse> findAll(Specification<Ward> spec, Pageable pageable);

    WardResponse findById(Long id);

    WardResponse findBySlug(String slug);

    PagedResponse<WardResponse> findByMunicipalityId(Long municipalityId, Pageable pageable);

    PagedResponse<WardResponse> findByMunicipalitySlug(String municipalitySlug, Pageable pageable);

    WardResponse create(WardRequest request);

    WardResponse update(Long id, WardRequest request);

    void delete(Long id);
}

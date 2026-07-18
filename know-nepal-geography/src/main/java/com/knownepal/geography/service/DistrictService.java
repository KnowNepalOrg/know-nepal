package com.knownepal.geography.service;

import com.knownepal.geography.dto.request.DistrictRequest;
import com.knownepal.geography.dto.response.DistrictResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.model.District;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface DistrictService {

    PagedResponse<DistrictResponse> findAll(Specification<District> spec, Pageable pageable);

    DistrictResponse findById(Long id);

    DistrictResponse findBySlug(String slug);

    DistrictResponse findByCode(String code);

    PagedResponse<DistrictResponse> findByProvinceId(Long provinceId, Pageable pageable);

    PagedResponse<DistrictResponse> findByProvinceSlug(String provinceSlug, Pageable pageable);

    DistrictResponse create(DistrictRequest request);

    DistrictResponse update(Long id, DistrictRequest request);

    void delete(Long id);
}

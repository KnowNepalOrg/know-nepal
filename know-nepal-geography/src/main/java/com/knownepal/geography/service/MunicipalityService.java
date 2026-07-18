package com.knownepal.geography.service;

import com.knownepal.geography.dto.request.MunicipalityRequest;
import com.knownepal.geography.dto.response.MunicipalityResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.WardResponse;
import com.knownepal.geography.model.Municipality;
import com.knownepal.geography.model.MunicipalityType;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface MunicipalityService {

    PagedResponse<MunicipalityResponse> findAll(Specification<Municipality> spec, Pageable pageable);

    MunicipalityResponse findById(Long id);

    MunicipalityResponse findBySlug(String slug);

    MunicipalityResponse findByCode(String code);

    PagedResponse<MunicipalityResponse> findByDistrictId(Long districtId, Pageable pageable);

    PagedResponse<MunicipalityResponse> findByDistrictSlug(String districtSlug, Pageable pageable);

    PagedResponse<MunicipalityResponse> findByType(MunicipalityType type, Pageable pageable);

    PagedResponse<WardResponse> findWardsBySlug(String municipalitySlug, Pageable pageable);

    MunicipalityResponse create(MunicipalityRequest request);

    MunicipalityResponse update(Long id, MunicipalityRequest request);

    void delete(Long id);
}

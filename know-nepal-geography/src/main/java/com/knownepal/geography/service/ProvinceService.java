package com.knownepal.geography.service;

import com.knownepal.geography.dto.request.ProvinceRequest;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.ProvinceResponse;
import com.knownepal.geography.model.Province;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface ProvinceService {

    PagedResponse<ProvinceResponse> findAll(Specification<Province> spec, Pageable pageable);

    ProvinceResponse findById(Long id);

    ProvinceResponse findBySlug(String slug);

    ProvinceResponse findByCode(String code);

    ProvinceResponse create(ProvinceRequest request);

    ProvinceResponse update(Long id, ProvinceRequest request);

    void delete(Long id);
}

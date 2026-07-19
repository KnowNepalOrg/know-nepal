package com.knownepal.education.service;

import com.knownepal.education.dto.request.CollegeRequest;
import com.knownepal.education.dto.response.CollegeResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.model.CollegeLevel;
import com.knownepal.education.model.CollegeType;

public interface CollegeService {

    CollegeResponse getBySlug(String slug);

    PagedResponse<CollegeResponse> getAll(String name, CollegeType type, CollegeLevel level,
                                           Long provinceId, Long districtId, int page, int size);

    CollegeResponse create(CollegeRequest request);

    CollegeResponse update(String slug, CollegeRequest request);

    void delete(String slug);
}

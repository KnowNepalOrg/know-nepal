package com.knownepal.education.service;

import com.knownepal.education.dto.request.SchoolRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.SchoolResponse;
import com.knownepal.education.model.EducationLevel;
import com.knownepal.education.model.SchoolType;

public interface SchoolService {

    SchoolResponse getBySlug(String slug);

    PagedResponse<SchoolResponse> getAll(String name, SchoolType type, EducationLevel level,
                                          Long provinceId, Long districtId, int page, int size);

    SchoolResponse create(SchoolRequest request);

    SchoolResponse update(String slug, SchoolRequest request);

    void delete(String slug);
}

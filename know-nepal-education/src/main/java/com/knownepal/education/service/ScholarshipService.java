package com.knownepal.education.service;

import com.knownepal.education.dto.request.ScholarshipRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.ScholarshipResponse;
import com.knownepal.education.model.ScholarshipType;

public interface ScholarshipService {

    ScholarshipResponse getBySlug(String slug);

    PagedResponse<ScholarshipResponse> getAll(String name, ScholarshipType type,
                                                Long provinceId, int page, int size);

    ScholarshipResponse create(ScholarshipRequest request);

    ScholarshipResponse update(String slug, ScholarshipRequest request);

    void delete(String slug);
}

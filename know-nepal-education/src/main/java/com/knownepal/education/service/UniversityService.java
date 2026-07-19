package com.knownepal.education.service;

import com.knownepal.education.dto.request.UniversityRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.UniversityResponse;
import com.knownepal.education.model.UniversityType;

public interface UniversityService {

    UniversityResponse getBySlug(String slug);

    PagedResponse<UniversityResponse> getAll(String name, UniversityType type, Long provinceId,
                                              int page, int size);

    UniversityResponse create(UniversityRequest request);

    UniversityResponse update(String slug, UniversityRequest request);

    void delete(String slug);
}

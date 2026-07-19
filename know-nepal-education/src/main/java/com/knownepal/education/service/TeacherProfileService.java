package com.knownepal.education.service;

import com.knownepal.education.dto.request.TeacherProfileRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.TeacherProfileResponse;
import com.knownepal.education.model.QualificationLevel;

public interface TeacherProfileService {

    TeacherProfileResponse getBySlug(String slug);

    PagedResponse<TeacherProfileResponse> getAll(String name, QualificationLevel level,
                                                  String institutionType, Long provinceId,
                                                  int page, int size);

    TeacherProfileResponse create(TeacherProfileRequest request);

    TeacherProfileResponse update(String slug, TeacherProfileRequest request);

    void delete(String slug);
}

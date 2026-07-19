package com.knownepal.education.service;

import com.knownepal.education.dto.request.ProgramRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.ProgramResponse;
import com.knownepal.education.model.InstitutionType;
import com.knownepal.education.model.ProgramLevel;

public interface ProgramService {

    ProgramResponse getBySlug(String slug);

    PagedResponse<ProgramResponse> getAll(String name, ProgramLevel level, String faculty,
                                           InstitutionType institutionType, int page, int size);

    ProgramResponse create(ProgramRequest request);

    ProgramResponse update(String slug, ProgramRequest request);

    void delete(String slug);
}

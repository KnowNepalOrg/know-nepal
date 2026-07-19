package com.knownepal.education.service;

import com.knownepal.education.dto.request.AcademicCalendarRequest;
import com.knownepal.education.dto.response.AcademicCalendarResponse;
import com.knownepal.education.dto.response.PagedResponse;

public interface AcademicCalendarService {

    PagedResponse<AcademicCalendarResponse> getAll(Long institutionId, String institutionType,
                                                    String academicYear, int page, int size);

    AcademicCalendarResponse getById(Long id);

    AcademicCalendarResponse create(AcademicCalendarRequest request);

    AcademicCalendarResponse update(Long id, AcademicCalendarRequest request);

    void delete(Long id);
}

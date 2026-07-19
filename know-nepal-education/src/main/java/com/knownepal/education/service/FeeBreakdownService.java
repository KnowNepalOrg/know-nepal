package com.knownepal.education.service;

import com.knownepal.education.dto.request.FeeBreakdownRequest;
import com.knownepal.education.dto.response.FeeBreakdownResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.model.FeeComponent;

public interface FeeBreakdownService {

    PagedResponse<FeeBreakdownResponse> getAll(Long programId, Long institutionId,
                                                FeeComponent component, String academicYear,
                                                int page, int size);

    FeeBreakdownResponse getById(Long id);

    FeeBreakdownResponse create(FeeBreakdownRequest request);

    FeeBreakdownResponse update(Long id, FeeBreakdownRequest request);

    void delete(Long id);
}

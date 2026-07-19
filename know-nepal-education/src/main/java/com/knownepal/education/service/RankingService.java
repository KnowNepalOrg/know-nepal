package com.knownepal.education.service;

import com.knownepal.education.dto.request.RankingRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.RankingResponse;
import com.knownepal.education.model.RankingSource;

public interface RankingService {

    PagedResponse<RankingResponse> getAll(String institutionType, Long institutionId,
                                          RankingSource source, String year,
                                          int page, int size);

    RankingResponse getById(Long id);

    RankingResponse create(RankingRequest request);

    RankingResponse update(Long id, RankingRequest request);

    void delete(Long id);
}

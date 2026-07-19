package com.knownepal.education.service;

import com.knownepal.education.dto.request.EntranceExamRequest;
import com.knownepal.education.dto.response.EntranceExamResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.model.ExamFormat;

public interface EntranceExamService {

    EntranceExamResponse getBySlug(String slug);

    PagedResponse<EntranceExamResponse> getAll(String name, ExamFormat format,
                                                Long boardId, int page, int size);

    EntranceExamResponse create(EntranceExamRequest request);

    EntranceExamResponse update(String slug, EntranceExamRequest request);

    void delete(String slug);
}

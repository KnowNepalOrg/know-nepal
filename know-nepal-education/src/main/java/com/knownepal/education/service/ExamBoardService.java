package com.knownepal.education.service;

import com.knownepal.education.dto.request.ExamBoardRequest;
import com.knownepal.education.dto.response.ExamBoardResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.model.BoardCategory;

public interface ExamBoardService {

    ExamBoardResponse getBySlug(String slug);

    PagedResponse<ExamBoardResponse> getAll(String name, BoardCategory category,
                                             Long provinceId, int page, int size);

    ExamBoardResponse create(ExamBoardRequest request);

    ExamBoardResponse update(String slug, ExamBoardRequest request);

    void delete(String slug);
}

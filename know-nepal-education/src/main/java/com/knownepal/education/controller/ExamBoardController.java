package com.knownepal.education.controller;

import com.knownepal.education.dto.request.ExamBoardRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.ExamBoardResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.model.BoardCategory;
import com.knownepal.education.service.ExamBoardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/exam-boards")
@Tag(name = "Exam Boards", description = "Examination board management")
@RequiredArgsConstructor
public class ExamBoardController {

    private final ExamBoardService service;

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get exam board by slug")
    public ResponseEntity<ApiResponse<ExamBoardResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.ok(service.getBySlug(slug)));
    }

    @GetMapping
    @Operation(summary = "List exam boards with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<ExamBoardResponse>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) BoardCategory category,
            @RequestParam(required = false) Long provinceId,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<ExamBoardResponse> result = service.getAll(
                name, category, provinceId,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new exam board")
    public ResponseEntity<ApiResponse<ExamBoardResponse>> create(@Valid @RequestBody ExamBoardRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/slug/{slug}")
    @Operation(summary = "Update an existing exam board by slug")
    public ResponseEntity<ApiResponse<ExamBoardResponse>> update(@PathVariable String slug,
                                                                  @Valid @RequestBody ExamBoardRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(slug, request)));
    }

    @DeleteMapping("/slug/{slug}")
    @Operation(summary = "Delete an exam board by slug")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String slug) {
        service.delete(slug);
        return ResponseEntity.noContent().build();
    }
}

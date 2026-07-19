package com.knownepal.education.controller;

import com.knownepal.education.dto.request.EntranceExamRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.EntranceExamResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.model.ExamFormat;
import com.knownepal.education.service.EntranceExamService;
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
@RequestMapping("/api/v1/entrance-exams")
@Tag(name = "Entrance Exams", description = "Entrance examination management")
@RequiredArgsConstructor
public class EntranceExamController {

    private final EntranceExamService service;

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get entrance exam by slug")
    public ResponseEntity<ApiResponse<EntranceExamResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.ok(service.getBySlug(slug)));
    }

    @GetMapping
    @Operation(summary = "List entrance exams with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<EntranceExamResponse>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) ExamFormat format,
            @RequestParam(required = false) Long boardId,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<EntranceExamResponse> result = service.getAll(
                name, format, boardId,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new entrance exam")
    public ResponseEntity<ApiResponse<EntranceExamResponse>> create(@Valid @RequestBody EntranceExamRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/slug/{slug}")
    @Operation(summary = "Update an existing entrance exam by slug")
    public ResponseEntity<ApiResponse<EntranceExamResponse>> update(@PathVariable String slug,
                                                                     @Valid @RequestBody EntranceExamRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(slug, request)));
    }

    @DeleteMapping("/slug/{slug}")
    @Operation(summary = "Delete an entrance exam by slug")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String slug) {
        service.delete(slug);
        return ResponseEntity.noContent().build();
    }
}

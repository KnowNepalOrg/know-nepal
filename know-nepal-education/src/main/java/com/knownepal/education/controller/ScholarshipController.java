package com.knownepal.education.controller;

import com.knownepal.education.dto.request.ScholarshipRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.ScholarshipResponse;
import com.knownepal.education.model.ScholarshipType;
import com.knownepal.education.service.ScholarshipService;
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
@RequestMapping("/api/v1/scholarships")
@Tag(name = "Scholarships", description = "Scholarship management")
@RequiredArgsConstructor
public class ScholarshipController {

    private final ScholarshipService service;

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get scholarship by slug")
    public ResponseEntity<ApiResponse<ScholarshipResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.ok(service.getBySlug(slug)));
    }

    @GetMapping
    @Operation(summary = "List scholarships with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<ScholarshipResponse>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) ScholarshipType type,
            @RequestParam(required = false) Long provinceId,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<ScholarshipResponse> result = service.getAll(
                name, type, provinceId,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new scholarship")
    public ResponseEntity<ApiResponse<ScholarshipResponse>> create(@Valid @RequestBody ScholarshipRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/slug/{slug}")
    @Operation(summary = "Update an existing scholarship by slug")
    public ResponseEntity<ApiResponse<ScholarshipResponse>> update(@PathVariable String slug,
                                                                    @Valid @RequestBody ScholarshipRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(slug, request)));
    }

    @DeleteMapping("/slug/{slug}")
    @Operation(summary = "Delete a scholarship by slug")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String slug) {
        service.delete(slug);
        return ResponseEntity.noContent().build();
    }
}

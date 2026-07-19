package com.knownepal.education.controller;

import com.knownepal.education.dto.request.UniversityRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.UniversityResponse;
import com.knownepal.education.model.UniversityType;
import com.knownepal.education.service.UniversityService;
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
@RequestMapping("/api/v1/universities")
@Tag(name = "Universities", description = "University management")
@RequiredArgsConstructor
public class UniversityController {

    private final UniversityService service;

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get university by slug")
    public ResponseEntity<ApiResponse<UniversityResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.ok(service.getBySlug(slug)));
    }

    @GetMapping
    @Operation(summary = "List universities with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<UniversityResponse>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) UniversityType type,
            @RequestParam(required = false) Long provinceId,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<UniversityResponse> result = service.getAll(
                name, type, provinceId,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new university")
    public ResponseEntity<ApiResponse<UniversityResponse>> create(@Valid @RequestBody UniversityRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/slug/{slug}")
    @Operation(summary = "Update an existing university by slug")
    public ResponseEntity<ApiResponse<UniversityResponse>> update(@PathVariable String slug,
                                                                   @Valid @RequestBody UniversityRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(slug, request)));
    }

    @DeleteMapping("/slug/{slug}")
    @Operation(summary = "Delete a university by slug")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String slug) {
        service.delete(slug);
        return ResponseEntity.noContent().build();
    }
}

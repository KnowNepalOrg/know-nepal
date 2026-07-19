package com.knownepal.education.controller;

import com.knownepal.education.dto.request.CollegeRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.CollegeResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.model.CollegeLevel;
import com.knownepal.education.model.CollegeType;
import com.knownepal.education.service.CollegeService;
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
@RequestMapping("/api/v1/colleges")
@Tag(name = "Colleges", description = "Higher secondary and bachelor colleges")
@RequiredArgsConstructor
public class CollegeController {

    private final CollegeService service;

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get college by slug")
    public ResponseEntity<ApiResponse<CollegeResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.ok(service.getBySlug(slug)));
    }

    @GetMapping
    @Operation(summary = "List colleges with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<CollegeResponse>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) CollegeType type,
            @RequestParam(required = false) CollegeLevel level,
            @RequestParam(required = false) Long provinceId,
            @RequestParam(required = false) Long districtId,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<CollegeResponse> result = service.getAll(
                name, type, level, provinceId, districtId,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new college")
    public ResponseEntity<ApiResponse<CollegeResponse>> create(@Valid @RequestBody CollegeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/slug/{slug}")
    @Operation(summary = "Update an existing college by slug")
    public ResponseEntity<ApiResponse<CollegeResponse>> update(@PathVariable String slug,
                                                                @Valid @RequestBody CollegeRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(slug, request)));
    }

    @DeleteMapping("/slug/{slug}")
    @Operation(summary = "Delete a college by slug")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String slug) {
        service.delete(slug);
        return ResponseEntity.noContent().build();
    }
}

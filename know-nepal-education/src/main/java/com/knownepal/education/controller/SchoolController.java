package com.knownepal.education.controller;

import com.knownepal.education.dto.request.SchoolRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.SchoolResponse;
import com.knownepal.education.model.EducationLevel;
import com.knownepal.education.model.SchoolType;
import com.knownepal.education.service.SchoolService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/v1/schools")
@Tag(name = "Schools", description = "K-12 school management")
@RequiredArgsConstructor
public class SchoolController {

    private final SchoolService service;

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get school by slug")
    public ResponseEntity<ApiResponse<SchoolResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.ok(service.getBySlug(slug)));
    }

    @GetMapping
    @Operation(summary = "List schools with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<SchoolResponse>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) SchoolType type,
            @RequestParam(required = false) EducationLevel level,
            @RequestParam(required = false) Long provinceId,
            @RequestParam(required = false) Long districtId,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<SchoolResponse> result = service.getAll(
                name, type, level, provinceId, districtId,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new school")
    public ResponseEntity<ApiResponse<SchoolResponse>> create(@Valid @RequestBody SchoolRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/slug/{slug}")
    @Operation(summary = "Update an existing school by slug")
    public ResponseEntity<ApiResponse<SchoolResponse>> update(@PathVariable String slug,
                                                               @Valid @RequestBody SchoolRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(slug, request)));
    }

    @DeleteMapping("/slug/{slug}")
    @Operation(summary = "Delete a school by slug")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String slug) {
        service.delete(slug);
        return ResponseEntity.noContent().build();
    }
}

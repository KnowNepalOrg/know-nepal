package com.knownepal.education.controller;

import com.knownepal.education.dto.request.TeacherProfileRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.TeacherProfileResponse;
import com.knownepal.education.model.QualificationLevel;
import com.knownepal.education.service.TeacherProfileService;
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
@RequestMapping("/api/v1/teacher-profiles")
@Tag(name = "Teacher Profiles", description = "Teacher profile management")
@RequiredArgsConstructor
public class TeacherProfileController {

    private final TeacherProfileService service;

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get teacher profile by slug")
    public ResponseEntity<ApiResponse<TeacherProfileResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.ok(service.getBySlug(slug)));
    }

    @GetMapping
    @Operation(summary = "List teacher profiles with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<TeacherProfileResponse>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) QualificationLevel level,
            @RequestParam(required = false) String institutionType,
            @RequestParam(required = false) Long provinceId,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<TeacherProfileResponse> result = service.getAll(
                name, level, institutionType, provinceId,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new teacher profile")
    public ResponseEntity<ApiResponse<TeacherProfileResponse>> create(@Valid @RequestBody TeacherProfileRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/slug/{slug}")
    @Operation(summary = "Update an existing teacher profile by slug")
    public ResponseEntity<ApiResponse<TeacherProfileResponse>> update(@PathVariable String slug,
                                                                       @Valid @RequestBody TeacherProfileRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(slug, request)));
    }

    @DeleteMapping("/slug/{slug}")
    @Operation(summary = "Delete a teacher profile by slug")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String slug) {
        service.delete(slug);
        return ResponseEntity.noContent().build();
    }
}

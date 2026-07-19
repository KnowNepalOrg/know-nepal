package com.knownepal.education.controller;

import com.knownepal.education.dto.request.ProgramRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.ProgramResponse;
import com.knownepal.education.model.InstitutionType;
import com.knownepal.education.model.ProgramLevel;
import com.knownepal.education.service.ProgramService;
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
@RequestMapping("/api/v1/programs")
@Tag(name = "Programs", description = "Academic programs across institutions")
@RequiredArgsConstructor
public class ProgramController {

    private final ProgramService service;

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get program by slug")
    public ResponseEntity<ApiResponse<ProgramResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.ok(service.getBySlug(slug)));
    }

    @GetMapping
    @Operation(summary = "List programs with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<ProgramResponse>>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) ProgramLevel level,
            @RequestParam(required = false) String faculty,
            @RequestParam(required = false) InstitutionType institutionType,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<ProgramResponse> result = service.getAll(
                name, level, faculty, institutionType,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new program")
    public ResponseEntity<ApiResponse<ProgramResponse>> create(@Valid @RequestBody ProgramRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/slug/{slug}")
    @Operation(summary = "Update an existing program by slug")
    public ResponseEntity<ApiResponse<ProgramResponse>> update(@PathVariable String slug,
                                                                @Valid @RequestBody ProgramRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(slug, request)));
    }

    @DeleteMapping("/slug/{slug}")
    @Operation(summary = "Delete a program by slug")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String slug) {
        service.delete(slug);
        return ResponseEntity.noContent().build();
    }
}

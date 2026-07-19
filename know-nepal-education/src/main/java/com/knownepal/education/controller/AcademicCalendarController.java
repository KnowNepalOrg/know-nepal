package com.knownepal.education.controller;

import com.knownepal.education.dto.request.AcademicCalendarRequest;
import com.knownepal.education.dto.response.AcademicCalendarResponse;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.service.AcademicCalendarService;
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
@RequestMapping("/api/v1/academic-calendars")
@Tag(name = "Academic Calendars", description = "Academic calendar management")
@RequiredArgsConstructor
public class AcademicCalendarController {

    private final AcademicCalendarService service;

    @GetMapping("/{id}")
    @Operation(summary = "Get academic calendar by id")
    public ResponseEntity<ApiResponse<AcademicCalendarResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(service.getById(id)));
    }

    @GetMapping
    @Operation(summary = "List academic calendars with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<AcademicCalendarResponse>>> getAll(
            @RequestParam(required = false) Long institutionId,
            @RequestParam(required = false) String institutionType,
            @RequestParam(required = false) String academicYear,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<AcademicCalendarResponse> result = service.getAll(
                institutionId, institutionType, academicYear,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new academic calendar entry")
    public ResponseEntity<ApiResponse<AcademicCalendarResponse>> create(@Valid @RequestBody AcademicCalendarRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing academic calendar entry by id")
    public ResponseEntity<ApiResponse<AcademicCalendarResponse>> update(@PathVariable Long id,
                                                                         @Valid @RequestBody AcademicCalendarRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an academic calendar entry by id")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

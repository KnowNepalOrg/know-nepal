package com.knownepal.education.controller;

import com.knownepal.education.dto.request.FeeBreakdownRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.FeeBreakdownResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.model.FeeComponent;
import com.knownepal.education.service.FeeBreakdownService;
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
@RequestMapping("/api/v1/fee-breakdowns")
@Tag(name = "Fee Breakdowns", description = "Fee breakdown management")
@RequiredArgsConstructor
public class FeeBreakdownController {

    private final FeeBreakdownService service;

    @GetMapping("/{id}")
    @Operation(summary = "Get fee breakdown by id")
    public ResponseEntity<ApiResponse<FeeBreakdownResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(service.getById(id)));
    }

    @GetMapping
    @Operation(summary = "List fee breakdowns with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<FeeBreakdownResponse>>> getAll(
            @RequestParam(required = false) Long programId,
            @RequestParam(required = false) Long institutionId,
            @RequestParam(required = false) FeeComponent component,
            @RequestParam(required = false) String academicYear,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<FeeBreakdownResponse> result = service.getAll(
                programId, institutionId, component, academicYear,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new fee breakdown")
    public ResponseEntity<ApiResponse<FeeBreakdownResponse>> create(@Valid @RequestBody FeeBreakdownRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing fee breakdown by id")
    public ResponseEntity<ApiResponse<FeeBreakdownResponse>> update(@PathVariable Long id,
                                                                     @Valid @RequestBody FeeBreakdownRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a fee breakdown by id")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

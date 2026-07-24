package com.knownepal.history.controller;

import com.knownepal.history.Constants;
import com.knownepal.history.dto.request.HistoricalFigureRequest;
import com.knownepal.history.dto.response.ApiResponse;
import com.knownepal.history.dto.response.HistoricalFigureResponse;
import com.knownepal.history.dto.response.PagedResponse;
import com.knownepal.history.service.HistoricalFigureService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/figures")
@RequiredArgsConstructor
@Tag(name = "Historical Figures", description = "CRUD operations for Nepal historical figures")
public class HistoricalFigureController {

    private final HistoricalFigureService service;

    @GetMapping
    @Operation(summary = "Get all figures with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<HistoricalFigureResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<HistoricalFigureResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<HistoricalFigureResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search figures by name")
    public ResponseEntity<ApiResponse<List<HistoricalFigureResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get figure by ID")
    public ResponseEntity<ApiResponse<HistoricalFigureResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get figure by slug")
    public ResponseEntity<ApiResponse<HistoricalFigureResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create a figure")
    public ResponseEntity<ApiResponse<HistoricalFigureResponse>> create(@Valid @RequestBody HistoricalFigureRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Historical figure created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a figure")
    public ResponseEntity<ApiResponse<HistoricalFigureResponse>> update(@PathVariable Long id, @Valid @RequestBody HistoricalFigureRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Historical figure updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a figure")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Historical figure deleted", null));
    }
}

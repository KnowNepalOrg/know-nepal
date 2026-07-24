package com.knownepal.history.controller;

import com.knownepal.history.Constants;
import com.knownepal.history.dto.request.HistoricalEraRequest;
import com.knownepal.history.dto.response.ApiResponse;
import com.knownepal.history.dto.response.HistoricalEraResponse;
import com.knownepal.history.dto.response.PagedResponse;
import com.knownepal.history.service.HistoricalEraService;
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
@RequestMapping("/api/v1/eras")
@RequiredArgsConstructor
@Tag(name = "Historical Eras", description = "CRUD operations for Nepal historical eras")
public class HistoricalEraController {

    private final HistoricalEraService service;

    @GetMapping
    @Operation(summary = "Get all eras with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<HistoricalEraResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<HistoricalEraResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<HistoricalEraResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search eras by name")
    public ResponseEntity<ApiResponse<List<HistoricalEraResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get era by ID")
    public ResponseEntity<ApiResponse<HistoricalEraResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get era by slug")
    public ResponseEntity<ApiResponse<HistoricalEraResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create an era")
    public ResponseEntity<ApiResponse<HistoricalEraResponse>> create(@Valid @RequestBody HistoricalEraRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Historical era created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an era")
    public ResponseEntity<ApiResponse<HistoricalEraResponse>> update(@PathVariable Long id, @Valid @RequestBody HistoricalEraRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Historical era updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an era")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Historical era deleted", null));
    }
}

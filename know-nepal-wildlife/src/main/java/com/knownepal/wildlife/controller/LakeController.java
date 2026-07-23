package com.knownepal.wildlife.controller;

import com.knownepal.wildlife.Constants;
import com.knownepal.wildlife.dto.request.LakeRequest;
import com.knownepal.wildlife.dto.response.ApiResponse;
import com.knownepal.wildlife.dto.response.LakeResponse;
import com.knownepal.wildlife.dto.response.PagedResponse;
import com.knownepal.wildlife.service.LakeService;
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
@RequestMapping("/api/v1/lakes")
@RequiredArgsConstructor
@Tag(name = "Lakes", description = "CRUD operations for Nepal lakes - natural, glacial, tectonic, crater, and artificial")
public class LakeController {

    private final LakeService service;

    @GetMapping
    @Operation(summary = "Get all lakes with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<LakeResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<LakeResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<LakeResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search lakes by name")
    public ResponseEntity<ApiResponse<List<LakeResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get lake by ID")
    public ResponseEntity<ApiResponse<LakeResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get lake by slug")
    public ResponseEntity<ApiResponse<LakeResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create a lake")
    public ResponseEntity<ApiResponse<LakeResponse>> create(@Valid @RequestBody LakeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Lake created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a lake")
    public ResponseEntity<ApiResponse<LakeResponse>> update(@PathVariable Long id, @Valid @RequestBody LakeRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Lake updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a lake")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Lake deleted", null));
    }
}

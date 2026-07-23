package com.knownepal.wildlife.controller;

import com.knownepal.wildlife.Constants;
import com.knownepal.wildlife.dto.request.FloraSpeciesRequest;
import com.knownepal.wildlife.dto.response.ApiResponse;
import com.knownepal.wildlife.dto.response.FloraSpeciesResponse;
import com.knownepal.wildlife.dto.response.PagedResponse;
import com.knownepal.wildlife.service.FloraSpeciesService;
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
@RequestMapping("/api/v1/flora")
@RequiredArgsConstructor
@Tag(name = "Flora Species", description = "CRUD operations for Nepal flora species - flowering plants, ferns, gymnosperms, bryophytes")
public class FloraSpeciesController {

    private final FloraSpeciesService service;

    @GetMapping
    @Operation(summary = "Get all flora species with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<FloraSpeciesResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<FloraSpeciesResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<FloraSpeciesResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search flora by name")
    public ResponseEntity<ApiResponse<List<FloraSpeciesResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get flora species by ID")
    public ResponseEntity<ApiResponse<FloraSpeciesResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get flora species by slug")
    public ResponseEntity<ApiResponse<FloraSpeciesResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create a flora species")
    public ResponseEntity<ApiResponse<FloraSpeciesResponse>> create(@Valid @RequestBody FloraSpeciesRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Flora species created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a flora species")
    public ResponseEntity<ApiResponse<FloraSpeciesResponse>> update(@PathVariable Long id, @Valid @RequestBody FloraSpeciesRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Flora species updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a flora species")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Flora species deleted", null));
    }
}

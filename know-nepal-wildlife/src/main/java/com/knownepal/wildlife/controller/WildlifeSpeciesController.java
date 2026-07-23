package com.knownepal.wildlife.controller;

import com.knownepal.wildlife.Constants;
import com.knownepal.wildlife.dto.request.WildlifeSpeciesRequest;
import com.knownepal.wildlife.dto.response.ApiResponse;
import com.knownepal.wildlife.dto.response.PagedResponse;
import com.knownepal.wildlife.dto.response.WildlifeSpeciesResponse;
import com.knownepal.wildlife.service.WildlifeSpeciesService;
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
@RequestMapping("/api/v1/species")
@RequiredArgsConstructor
@Tag(name = "Wildlife Species", description = "CRUD operations for Nepal wildlife species - mammals, birds, reptiles, amphibians, fish, butterflies")
public class WildlifeSpeciesController {

    private final WildlifeSpeciesService service;

    @GetMapping
    @Operation(summary = "Get all species with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<WildlifeSpeciesResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<WildlifeSpeciesResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<WildlifeSpeciesResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search species by name")
    public ResponseEntity<ApiResponse<List<WildlifeSpeciesResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get species by ID")
    public ResponseEntity<ApiResponse<WildlifeSpeciesResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get species by slug")
    public ResponseEntity<ApiResponse<WildlifeSpeciesResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create a species")
    public ResponseEntity<ApiResponse<WildlifeSpeciesResponse>> create(@Valid @RequestBody WildlifeSpeciesRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Wildlife species created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a species")
    public ResponseEntity<ApiResponse<WildlifeSpeciesResponse>> update(@PathVariable Long id, @Valid @RequestBody WildlifeSpeciesRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Wildlife species updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a species")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Wildlife species deleted", null));
    }
}

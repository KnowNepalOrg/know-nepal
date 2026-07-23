package com.knownepal.wildlife.controller;

import com.knownepal.wildlife.Constants;
import com.knownepal.wildlife.dto.request.NationalParkRequest;
import com.knownepal.wildlife.dto.response.ApiResponse;
import com.knownepal.wildlife.dto.response.NationalParkResponse;
import com.knownepal.wildlife.dto.response.PagedResponse;
import com.knownepal.wildlife.service.NationalParkService;
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
@RequestMapping("/api/v1/parks")
@RequiredArgsConstructor
@Tag(name = "National Parks & Protected Areas", description = "CRUD operations for Nepal national parks, wildlife reserves, and conservation areas")
public class NationalParkController {

    private final NationalParkService service;

    @GetMapping
    @Operation(summary = "Get all parks with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<NationalParkResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<NationalParkResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<NationalParkResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search parks by name")
    public ResponseEntity<ApiResponse<List<NationalParkResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get park by ID")
    public ResponseEntity<ApiResponse<NationalParkResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get park by slug")
    public ResponseEntity<ApiResponse<NationalParkResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create a park")
    public ResponseEntity<ApiResponse<NationalParkResponse>> create(@Valid @RequestBody NationalParkRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("National park created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a park")
    public ResponseEntity<ApiResponse<NationalParkResponse>> update(@PathVariable Long id, @Valid @RequestBody NationalParkRequest request) {
        return ResponseEntity.ok(ApiResponse.success("National park updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a park")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("National park deleted", null));
    }
}

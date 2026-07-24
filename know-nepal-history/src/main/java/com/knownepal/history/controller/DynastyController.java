package com.knownepal.history.controller;

import com.knownepal.history.Constants;
import com.knownepal.history.dto.request.DynastyRequest;
import com.knownepal.history.dto.response.ApiResponse;
import com.knownepal.history.dto.response.DynastyResponse;
import com.knownepal.history.dto.response.PagedResponse;
import com.knownepal.history.service.DynastyService;
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
@RequestMapping("/api/v1/dynasties")
@RequiredArgsConstructor
@Tag(name = "Dynasties", description = "CRUD operations for Nepal dynasties and political systems")
public class DynastyController {

    private final DynastyService service;

    @GetMapping
    @Operation(summary = "Get all dynasties with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<DynastyResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<DynastyResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<DynastyResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search dynasties by name")
    public ResponseEntity<ApiResponse<List<DynastyResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get dynasty by ID")
    public ResponseEntity<ApiResponse<DynastyResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get dynasty by slug")
    public ResponseEntity<ApiResponse<DynastyResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create a dynasty")
    public ResponseEntity<ApiResponse<DynastyResponse>> create(@Valid @RequestBody DynastyRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Dynasty created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a dynasty")
    public ResponseEntity<ApiResponse<DynastyResponse>> update(@PathVariable Long id, @Valid @RequestBody DynastyRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Dynasty updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a dynasty")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Dynasty deleted", null));
    }
}

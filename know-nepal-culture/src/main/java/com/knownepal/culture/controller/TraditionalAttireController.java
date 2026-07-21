package com.knownepal.culture.controller;

import com.knownepal.culture.Constants;
import com.knownepal.culture.dto.request.TraditionalAttireRequest;
import com.knownepal.culture.dto.response.ApiResponse;
import com.knownepal.culture.dto.response.PagedResponse;
import com.knownepal.culture.dto.response.TraditionalAttireResponse;
import com.knownepal.culture.service.TraditionalAttireService;
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
@RequestMapping("/api/v1/traditional-attires")
@RequiredArgsConstructor
@Tag(name = "Traditional Attires", description = "CRUD operations for Nepal traditional attires")
public class TraditionalAttireController {

    private final TraditionalAttireService service;

    @GetMapping
    @Operation(summary = "Get all traditional attires with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<TraditionalAttireResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<TraditionalAttireResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<TraditionalAttireResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search traditional attires by name")
    public ResponseEntity<ApiResponse<List<TraditionalAttireResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get traditional attire by ID")
    public ResponseEntity<ApiResponse<TraditionalAttireResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get traditional attire by slug")
    public ResponseEntity<ApiResponse<TraditionalAttireResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create a traditional attire")
    public ResponseEntity<ApiResponse<TraditionalAttireResponse>> create(@Valid @RequestBody TraditionalAttireRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Traditional attire created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a traditional attire")
    public ResponseEntity<ApiResponse<TraditionalAttireResponse>> update(@PathVariable Long id, @Valid @RequestBody TraditionalAttireRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Traditional attire updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a traditional attire")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Traditional attire deleted", null));
    }
}

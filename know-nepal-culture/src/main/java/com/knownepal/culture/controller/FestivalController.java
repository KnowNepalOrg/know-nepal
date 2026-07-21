package com.knownepal.culture.controller;

import com.knownepal.culture.Constants;
import com.knownepal.culture.dto.request.FestivalRequest;
import com.knownepal.culture.dto.response.ApiResponse;
import com.knownepal.culture.dto.response.FestivalResponse;
import com.knownepal.culture.dto.response.PagedResponse;
import com.knownepal.culture.service.FestivalService;
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
@RequestMapping("/api/v1/festivals")
@RequiredArgsConstructor
@Tag(name = "Festivals", description = "CRUD operations for Nepal festivals")
public class FestivalController {

    private final FestivalService service;

    @GetMapping
    @Operation(summary = "Get all festivals with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<FestivalResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<FestivalResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<FestivalResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search festivals by name")
    public ResponseEntity<ApiResponse<List<FestivalResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get festival by ID")
    public ResponseEntity<ApiResponse<FestivalResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get festival by slug")
    public ResponseEntity<ApiResponse<FestivalResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create a festival")
    public ResponseEntity<ApiResponse<FestivalResponse>> create(@Valid @RequestBody FestivalRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Festival created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a festival")
    public ResponseEntity<ApiResponse<FestivalResponse>> update(@PathVariable Long id, @Valid @RequestBody FestivalRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Festival updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a festival")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Festival deleted", null));
    }
}

package com.knownepal.culture.controller;

import com.knownepal.culture.Constants;
import com.knownepal.culture.dto.request.ArtFormRequest;
import com.knownepal.culture.dto.response.ApiResponse;
import com.knownepal.culture.dto.response.ArtFormResponse;
import com.knownepal.culture.dto.response.PagedResponse;
import com.knownepal.culture.service.ArtFormService;
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
@RequestMapping("/api/v1/art-forms")
@RequiredArgsConstructor
@Tag(name = "Art Forms", description = "CRUD operations for Nepal art forms")
public class ArtFormController {

    private final ArtFormService service;

    @GetMapping
    @Operation(summary = "Get all art forms with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<ArtFormResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<ArtFormResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<ArtFormResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search art forms by name")
    public ResponseEntity<ApiResponse<List<ArtFormResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get art form by ID")
    public ResponseEntity<ApiResponse<ArtFormResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get art form by slug")
    public ResponseEntity<ApiResponse<ArtFormResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create an art form")
    public ResponseEntity<ApiResponse<ArtFormResponse>> create(@Valid @RequestBody ArtFormRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Art form created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an art form")
    public ResponseEntity<ApiResponse<ArtFormResponse>> update(@PathVariable Long id, @Valid @RequestBody ArtFormRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Art form updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an art form")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Art form deleted", null));
    }
}

package com.knownepal.culture.controller;

import com.knownepal.culture.Constants;
import com.knownepal.culture.dto.request.EthnicGroupRequest;
import com.knownepal.culture.dto.response.ApiResponse;
import com.knownepal.culture.dto.response.EthnicGroupResponse;
import com.knownepal.culture.dto.response.PagedResponse;
import com.knownepal.culture.service.EthnicGroupService;
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
@RequestMapping("/api/v1/ethnic-groups")
@RequiredArgsConstructor
@Tag(name = "Ethnic Groups", description = "CRUD operations for Nepal ethnic groups")
public class EthnicGroupController {

    private final EthnicGroupService service;

    @GetMapping
    @Operation(summary = "Get all ethnic groups with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<EthnicGroupResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<EthnicGroupResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<EthnicGroupResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search ethnic groups by name")
    public ResponseEntity<ApiResponse<List<EthnicGroupResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get ethnic group by ID")
    public ResponseEntity<ApiResponse<EthnicGroupResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get ethnic group by slug")
    public ResponseEntity<ApiResponse<EthnicGroupResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create an ethnic group")
    public ResponseEntity<ApiResponse<EthnicGroupResponse>> create(@Valid @RequestBody EthnicGroupRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Ethnic group created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an ethnic group")
    public ResponseEntity<ApiResponse<EthnicGroupResponse>> update(@PathVariable Long id, @Valid @RequestBody EthnicGroupRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Ethnic group updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an ethnic group")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Ethnic group deleted", null));
    }
}

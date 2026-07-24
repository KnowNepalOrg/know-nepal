package com.knownepal.history.controller;

import com.knownepal.history.Constants;
import com.knownepal.history.dto.request.HistoricalEventRequest;
import com.knownepal.history.dto.response.ApiResponse;
import com.knownepal.history.dto.response.HistoricalEventResponse;
import com.knownepal.history.dto.response.PagedResponse;
import com.knownepal.history.service.HistoricalEventService;
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
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
@Tag(name = "Historical Events", description = "CRUD operations for Nepal historical events")
public class HistoricalEventController {

    private final HistoricalEventService service;

    @GetMapping
    @Operation(summary = "Get all events with pagination and optional filters")
    public ResponseEntity<ApiResponse<PagedResponse<HistoricalEventResponse>>> getAll(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size,
            @RequestParam(required = false) Map<String, String> filters) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        List<HistoricalEventResponse> content = service.findAll(pageable, filters);
        long total = service.count(filters);
        int totalPages = (int) Math.ceil((double) total / size);
        PagedResponse<HistoricalEventResponse> paged = new PagedResponse<>(content, page, size, total, totalPages, page == 0, page >= totalPages - 1);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/search")
    @Operation(summary = "Search events by name")
    public ResponseEntity<ApiResponse<List<HistoricalEventResponse>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE) int page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) int size) {
        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(ApiResponse.success(service.search(q, pageable)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get event by ID")
    public ResponseEntity<ApiResponse<HistoricalEventResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get event by slug")
    public ResponseEntity<ApiResponse<HistoricalEventResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create an event")
    public ResponseEntity<ApiResponse<HistoricalEventResponse>> create(@Valid @RequestBody HistoricalEventRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Historical event created", service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an event")
    public ResponseEntity<ApiResponse<HistoricalEventResponse>> update(@PathVariable Long id, @Valid @RequestBody HistoricalEventRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Historical event updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an event")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Historical event deleted", null));
    }
}

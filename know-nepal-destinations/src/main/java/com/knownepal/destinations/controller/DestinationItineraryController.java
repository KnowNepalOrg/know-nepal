package com.knownepal.destinations.controller;

import com.knownepal.destinations.common.Constants;
import com.knownepal.destinations.dto.request.DestinationItineraryRequest;
import com.knownepal.destinations.dto.response.ApiResponse;
import com.knownepal.destinations.dto.response.DestinationItineraryResponse;
import com.knownepal.destinations.dto.response.PagedResponse;
import com.knownepal.destinations.service.DestinationItineraryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itineraries")
@RequiredArgsConstructor
@Tag(name = "Destination Itineraries", description = "CRUD operations for destination itineraries")
public class DestinationItineraryController {

    private final DestinationItineraryService service;

    @GetMapping
    @Operation(summary = "Get all itineraries")
    public ResponseEntity<ApiResponse<PagedResponse<DestinationItineraryResponse>>> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, Math.min(size, Constants.MAX_PAGE_SIZE));
        List<DestinationItineraryResponse> content = service.findAll(pageable);
        long total = service.count();
        PagedResponse<DestinationItineraryResponse> paged = new PagedResponse<>(content, page, size, total,
                (int) Math.ceil((double) total / size), page == 0, (long) (page + 1) * size >= total);
        return ResponseEntity.ok(ApiResponse.success(paged));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get itinerary by ID")
    public ResponseEntity<ApiResponse<DestinationItineraryResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get itinerary by slug")
    public ResponseEntity<ApiResponse<DestinationItineraryResponse>> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(ApiResponse.success(service.findBySlug(slug)));
    }

    @PostMapping
    @Operation(summary = "Create an itinerary")
    public ResponseEntity<ApiResponse<DestinationItineraryResponse>> create(@Valid @RequestBody DestinationItineraryRequest request) {
        DestinationItineraryResponse response = service.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Itinerary created", response));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an itinerary")
    public ResponseEntity<ApiResponse<DestinationItineraryResponse>> update(@PathVariable Long id, @Valid @RequestBody DestinationItineraryRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Itinerary updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an itinerary")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Itinerary deleted", null));
    }
}

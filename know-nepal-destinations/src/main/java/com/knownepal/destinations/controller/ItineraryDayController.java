package com.knownepal.destinations.controller;

import com.knownepal.destinations.dto.request.ItineraryDayRequest;
import com.knownepal.destinations.dto.response.ApiResponse;
import com.knownepal.destinations.dto.response.ItineraryDayResponse;
import com.knownepal.destinations.service.ItineraryDayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itineraries/{itineraryId}/days")
@RequiredArgsConstructor
@Tag(name = "Itinerary Days", description = "CRUD operations for itinerary days")
public class ItineraryDayController {

    private final ItineraryDayService service;

    @GetMapping
    @Operation(summary = "Get days for an itinerary")
    public ResponseEntity<ApiResponse<List<ItineraryDayResponse>>> getByItinerary(@PathVariable Long itineraryId) {
        return ResponseEntity.ok(ApiResponse.success(service.findByItineraryId(itineraryId)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get day by ID")
    public ResponseEntity<ApiResponse<ItineraryDayResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @PostMapping
    @Operation(summary = "Create a day")
    public ResponseEntity<ApiResponse<ItineraryDayResponse>> create(
            @PathVariable Long itineraryId, @Valid @RequestBody ItineraryDayRequest request) {
        ItineraryDayResponse response = service.create(itineraryId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Day created", response));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a day")
    public ResponseEntity<ApiResponse<ItineraryDayResponse>> update(
            @PathVariable Long id, @Valid @RequestBody ItineraryDayRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Day updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a day")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Day deleted", null));
    }
}

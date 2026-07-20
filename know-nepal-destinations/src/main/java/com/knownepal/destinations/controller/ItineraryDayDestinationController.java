package com.knownepal.destinations.controller;

import com.knownepal.destinations.dto.request.ItineraryDayDestinationRequest;
import com.knownepal.destinations.dto.response.ApiResponse;
import com.knownepal.destinations.dto.response.ItineraryDayDestinationResponse;
import com.knownepal.destinations.service.ItineraryDayDestinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/itinerary-days/{dayId}/destinations")
@RequiredArgsConstructor
@Tag(name = "Itinerary Day Destinations", description = "CRUD operations for itinerary day destinations")
public class ItineraryDayDestinationController {

    private final ItineraryDayDestinationService service;

    @GetMapping
    @Operation(summary = "Get destinations for a day")
    public ResponseEntity<ApiResponse<List<ItineraryDayDestinationResponse>>> getByDayId(@PathVariable Long dayId) {
        return ResponseEntity.ok(ApiResponse.success(service.findByDayId(dayId)));
    }

    @PostMapping
    @Operation(summary = "Add destination to day")
    public ResponseEntity<ApiResponse<ItineraryDayDestinationResponse>> create(
            @PathVariable Long dayId, @Valid @RequestBody ItineraryDayDestinationRequest request) {
        ItineraryDayDestinationResponse response = service.create(dayId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Day destination added", response));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove destination from day")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Day destination removed", null));
    }
}

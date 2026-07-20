package com.knownepal.destinations.controller;

import com.knownepal.destinations.dto.request.DestinationWeatherRequest;
import com.knownepal.destinations.dto.response.ApiResponse;
import com.knownepal.destinations.dto.response.DestinationWeatherResponse;
import com.knownepal.destinations.service.DestinationWeatherService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destinations/{destinationId}/weather")
@RequiredArgsConstructor
@Tag(name = "Destination Weather", description = "CRUD operations for destination weather")
public class DestinationWeatherController {

    private final DestinationWeatherService service;

    @GetMapping
    @Operation(summary = "Get weather for a destination")
    public ResponseEntity<ApiResponse<List<DestinationWeatherResponse>>> getByDestination(@PathVariable Long destinationId) {
        return ResponseEntity.ok(ApiResponse.success(service.findByDestinationId(destinationId)));
    }

    @PostMapping
    @Operation(summary = "Add weather data")
    public ResponseEntity<ApiResponse<DestinationWeatherResponse>> create(
            @PathVariable Long destinationId, @Valid @RequestBody DestinationWeatherRequest request) {
        DestinationWeatherResponse response = service.create(destinationId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Weather data added", response));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update weather data")
    public ResponseEntity<ApiResponse<DestinationWeatherResponse>> update(
            @PathVariable Long id, @Valid @RequestBody DestinationWeatherRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Weather data updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete weather data")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Weather data deleted", null));
    }
}

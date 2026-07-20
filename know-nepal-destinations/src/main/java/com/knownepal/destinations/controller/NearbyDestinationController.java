package com.knownepal.destinations.controller;

import com.knownepal.destinations.dto.request.NearbyDestinationRequest;
import com.knownepal.destinations.dto.response.ApiResponse;
import com.knownepal.destinations.dto.response.NearbyDestinationResponse;
import com.knownepal.destinations.service.NearbyDestinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destinations/{destinationId}/nearby")
@RequiredArgsConstructor
@Tag(name = "Nearby Destinations", description = "CRUD operations for nearby destinations")
public class NearbyDestinationController {

    private final NearbyDestinationService service;

    @GetMapping
    @Operation(summary = "Get nearby destinations")
    public ResponseEntity<ApiResponse<List<NearbyDestinationResponse>>> getByDestination(@PathVariable Long destinationId) {
        return ResponseEntity.ok(ApiResponse.success(service.findByDestinationId(destinationId)));
    }

    @PostMapping
    @Operation(summary = "Add nearby destination")
    public ResponseEntity<ApiResponse<NearbyDestinationResponse>> create(
            @PathVariable Long destinationId, @Valid @RequestBody NearbyDestinationRequest request) {
        NearbyDestinationResponse response = service.create(destinationId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Nearby destination added", response));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove nearby destination")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Nearby destination removed", null));
    }
}

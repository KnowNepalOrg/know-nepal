package com.knownepal.destinations.controller;

import com.knownepal.destinations.dto.request.RouteDestinationRequest;
import com.knownepal.destinations.dto.response.ApiResponse;
import com.knownepal.destinations.dto.response.RouteDestinationResponse;
import com.knownepal.destinations.service.RouteDestinationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/routes/{routeId}/destinations")
@RequiredArgsConstructor
@Tag(name = "Route Destinations", description = "CRUD operations for route destinations")
public class RouteDestinationController {

    private final RouteDestinationService service;

    @GetMapping
    @Operation(summary = "Get destinations for a route")
    public ResponseEntity<ApiResponse<List<RouteDestinationResponse>>> getByRoute(@PathVariable Long routeId) {
        return ResponseEntity.ok(ApiResponse.success(service.findByRouteId(routeId)));
    }

    @PostMapping
    @Operation(summary = "Add destination to route")
    public ResponseEntity<ApiResponse<RouteDestinationResponse>> create(
            @PathVariable Long routeId, @Valid @RequestBody RouteDestinationRequest request) {
        RouteDestinationResponse response = service.create(routeId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Route destination added", response));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Remove destination from route")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Route destination removed", null));
    }
}

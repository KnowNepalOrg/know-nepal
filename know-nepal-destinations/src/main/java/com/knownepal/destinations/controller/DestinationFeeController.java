package com.knownepal.destinations.controller;

import com.knownepal.destinations.dto.request.DestinationFeeRequest;
import com.knownepal.destinations.dto.response.ApiResponse;
import com.knownepal.destinations.dto.response.DestinationFeeResponse;
import com.knownepal.destinations.service.DestinationFeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/destinations/{destinationId}/fees")
@RequiredArgsConstructor
@Tag(name = "Destination Fees", description = "CRUD operations for destination fees")
public class DestinationFeeController {

    private final DestinationFeeService service;

    @GetMapping
    @Operation(summary = "Get fees for a destination")
    public ResponseEntity<ApiResponse<List<DestinationFeeResponse>>> getByDestination(@PathVariable Long destinationId) {
        return ResponseEntity.ok(ApiResponse.success(service.findByDestinationId(destinationId)));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get fee by ID")
    public ResponseEntity<ApiResponse<DestinationFeeResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.success(service.findById(id)));
    }

    @PostMapping
    @Operation(summary = "Create a fee")
    public ResponseEntity<ApiResponse<DestinationFeeResponse>> create(
            @PathVariable Long destinationId, @Valid @RequestBody DestinationFeeRequest request) {
        DestinationFeeResponse response = service.create(destinationId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Fee created", response));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a fee")
    public ResponseEntity<ApiResponse<DestinationFeeResponse>> update(
            @PathVariable Long id, @Valid @RequestBody DestinationFeeRequest request) {
        return ResponseEntity.ok(ApiResponse.success("Fee updated", service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a fee")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok(ApiResponse.success("Fee deleted", null));
    }
}

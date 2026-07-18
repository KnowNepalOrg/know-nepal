package com.knownepal.geography.controller;

import com.knownepal.geography.dto.request.WardRequest;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.WardResponse;
import com.knownepal.geography.service.WardService;
import com.knownepal.geography.specification.WardSpecification;
import com.knownepal.geography.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.WARDS)
@RequiredArgsConstructor
@Tag(name = "Ward", description = "Nepal Ward Management API — paginated list endpoints, slug-based lookups, CRUD operations")
public class WardController {

    private final WardService wardService;

    @GetMapping
    @Operation(summary = "Get all wards with optional filtering", description = "Returns a paginated list of wards. Supports name, number, municipalityId, districtId, and provinceId filtering.")
    public ResponseEntity<PagedResponse<WardResponse>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer number,
            @RequestParam(required = false) Long municipalityId,
            @RequestParam(required = false) Long districtId,
            @RequestParam(required = false) Long provinceId,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(wardService.findAll(
                WardSpecification.build(name, number, municipalityId, districtId, provinceId), pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get ward by ID")
    public ResponseEntity<WardResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(wardService.findById(id));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get ward by slug")
    public ResponseEntity<WardResponse> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(wardService.findBySlug(slug));
    }

    @GetMapping("/municipality/{municipalityId}")
    @Operation(summary = "Get all wards by municipality ID, ordered by ward number", description = "Returns paginated wards sorted by ward number for the given municipality ID.")
    public ResponseEntity<PagedResponse<WardResponse>> getByMunicipalityId(
            @PathVariable Long municipalityId,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "number") Pageable pageable) {
        return ResponseEntity.ok(wardService.findByMunicipalityId(municipalityId, pageable));
    }

    @GetMapping("/municipality/slug/{municipalitySlug}")
    @Operation(summary = "Get all wards by municipality slug, ordered by ward number", description = "Returns paginated wards sorted by ward number for the given municipality slug.")
    public ResponseEntity<PagedResponse<WardResponse>> getByMunicipalitySlug(
            @PathVariable String municipalitySlug,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "number") Pageable pageable) {
        return ResponseEntity.ok(wardService.findByMunicipalitySlug(municipalitySlug, pageable));
    }

    @PostMapping
    @Operation(summary = "Create a new ward")
    public ResponseEntity<WardResponse> create(@Valid @RequestBody WardRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(wardService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing ward")
    public ResponseEntity<WardResponse> update(@PathVariable Long id, @Valid @RequestBody WardRequest request) {
        return ResponseEntity.ok(wardService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a ward")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        wardService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

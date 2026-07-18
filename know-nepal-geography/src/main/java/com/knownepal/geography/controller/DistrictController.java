package com.knownepal.geography.controller;

import com.knownepal.geography.dto.request.DistrictRequest;
import com.knownepal.geography.dto.response.DistrictResponse;
import com.knownepal.geography.dto.response.MunicipalityResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.service.DistrictService;
import com.knownepal.geography.service.MunicipalityService;
import com.knownepal.geography.specification.DistrictSpecification;
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
@RequestMapping(Constants.DISTRICTS)
@RequiredArgsConstructor
@Tag(name = "District", description = "Nepal District Management API — paginated list endpoints, slug-based lookups, CRUD operations")
public class DistrictController {

    private final DistrictService districtService;
    private final MunicipalityService municipalityService;

    @GetMapping
    @Operation(summary = "Get all districts with optional filtering", description = "Returns a paginated list of districts. Supports name, code, provinceId, and headquarters filtering.")
    public ResponseEntity<PagedResponse<DistrictResponse>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) Long provinceId,
            @RequestParam(required = false) String headquarters,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(districtService.findAll(
                DistrictSpecification.build(name, code, provinceId, headquarters), pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get district by ID")
    public ResponseEntity<DistrictResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(districtService.findById(id));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get district by slug")
    public ResponseEntity<DistrictResponse> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(districtService.findBySlug(slug));
    }

    @GetMapping("/code/{code}")
    @Operation(summary = "Get district by code")
    public ResponseEntity<DistrictResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(districtService.findByCode(code));
    }

    @GetMapping("/province/{provinceId}")
    @Operation(summary = "Get all districts by province ID", description = "Returns paginated districts for the given province ID.")
    public ResponseEntity<PagedResponse<DistrictResponse>> getByProvinceId(
            @PathVariable Long provinceId,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(districtService.findByProvinceId(provinceId, pageable));
    }

    @GetMapping("/slug/{slug}/municipalities")
    @Operation(summary = "Get all municipalities in a district by slug", description = "Returns paginated municipalities belonging to the given district slug.")
    public ResponseEntity<PagedResponse<MunicipalityResponse>> getMunicipalitiesBySlug(
            @PathVariable String slug,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(municipalityService.findByDistrictSlug(slug, pageable));
    }

    @PostMapping
    @Operation(summary = "Create a new district")
    public ResponseEntity<DistrictResponse> create(@Valid @RequestBody DistrictRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(districtService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing district")
    public ResponseEntity<DistrictResponse> update(@PathVariable Long id, @Valid @RequestBody DistrictRequest request) {
        return ResponseEntity.ok(districtService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a district")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        districtService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

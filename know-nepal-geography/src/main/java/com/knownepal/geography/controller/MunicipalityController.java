package com.knownepal.geography.controller;

import com.knownepal.geography.dto.request.MunicipalityRequest;
import com.knownepal.geography.dto.response.MunicipalityResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.WardResponse;
import com.knownepal.geography.model.MunicipalityType;
import com.knownepal.geography.service.MunicipalityService;
import com.knownepal.geography.specification.MunicipalitySpecification;
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
@RequestMapping(Constants.MUNICIPALITIES)
@RequiredArgsConstructor
@Tag(name = "Municipality", description = "Nepal Municipality Management API — paginated list endpoints, slug-based lookups, CRUD operations")
public class MunicipalityController {

    private final MunicipalityService municipalityService;

    @GetMapping
    @Operation(summary = "Get all municipalities with optional filtering", description = "Returns a paginated list of municipalities. Supports name, code, type, districtId, and provinceId filtering.")
    public ResponseEntity<PagedResponse<MunicipalityResponse>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) MunicipalityType type,
            @RequestParam(required = false) Long districtId,
            @RequestParam(required = false) Long provinceId,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(municipalityService.findAll(
                MunicipalitySpecification.build(name, code, type, districtId, provinceId), pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get municipality by ID")
    public ResponseEntity<MunicipalityResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(municipalityService.findById(id));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get municipality by slug")
    public ResponseEntity<MunicipalityResponse> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(municipalityService.findBySlug(slug));
    }

    @GetMapping("/slug/{slug}/wards")
    @Operation(summary = "Get all wards in a municipality by slug", description = "Returns paginated wards belonging to the given municipality slug.")
    public ResponseEntity<PagedResponse<WardResponse>> getWardsBySlug(
            @PathVariable String slug,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "number") Pageable pageable) {
        return ResponseEntity.ok(municipalityService.findWardsBySlug(slug, pageable));
    }

    @GetMapping("/code/{code}")
    @Operation(summary = "Get municipality by code")
    public ResponseEntity<MunicipalityResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(municipalityService.findByCode(code));
    }

    @GetMapping("/district/{districtId}")
    @Operation(summary = "Get all municipalities by district ID", description = "Returns paginated municipalities for the given district ID.")
    public ResponseEntity<PagedResponse<MunicipalityResponse>> getByDistrictId(
            @PathVariable Long districtId,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(municipalityService.findByDistrictId(districtId, pageable));
    }

    @GetMapping("/type/{type}")
    @Operation(summary = "Get all municipalities by type", description = "Returns paginated municipalities filtered by type (METROPOLITAN_CITY, SUB_METROPOLITAN_CITY, MUNICIPALITY, etc.).")
    public ResponseEntity<PagedResponse<MunicipalityResponse>> getByType(
            @PathVariable MunicipalityType type,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(municipalityService.findByType(type, pageable));
    }

    @PostMapping
    @Operation(summary = "Create a new municipality")
    public ResponseEntity<MunicipalityResponse> create(@Valid @RequestBody MunicipalityRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(municipalityService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing municipality")
    public ResponseEntity<MunicipalityResponse> update(@PathVariable Long id, @Valid @RequestBody MunicipalityRequest request) {
        return ResponseEntity.ok(municipalityService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a municipality")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        municipalityService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

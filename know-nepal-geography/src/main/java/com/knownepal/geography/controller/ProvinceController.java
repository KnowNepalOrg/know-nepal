package com.knownepal.geography.controller;

import com.knownepal.geography.dto.request.ProvinceRequest;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.ProvinceResponse;
import com.knownepal.geography.service.DistrictService;
import com.knownepal.geography.service.ProvinceService;
import com.knownepal.geography.specification.ProvinceSpecification;
import com.knownepal.geography.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.PROVINCES)
@RequiredArgsConstructor
@Tag(name = "Province", description = "Nepal Province Management API — paginated list endpoints, slug-based lookups, CRUD operations")
public class ProvinceController {

    private final ProvinceService provinceService;
    private final DistrictService districtService;

    @GetMapping
    @Operation(summary = "Get all provinces with optional filtering", description = "Returns a paginated list of provinces. Supports name, code, and capital filtering.")
    public ResponseEntity<PagedResponse<ProvinceResponse>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String capital,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(provinceService.findAll(
                ProvinceSpecification.build(name, code, capital), pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get province by ID")
    public ResponseEntity<ProvinceResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(provinceService.findById(id));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get province by slug")
    public ResponseEntity<ProvinceResponse> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(provinceService.findBySlug(slug));
    }

    @GetMapping("/code/{code}")
    @Operation(summary = "Get province by code")
    public ResponseEntity<ProvinceResponse> getByCode(@PathVariable String code) {
        return ResponseEntity.ok(provinceService.findByCode(code));
    }

    @GetMapping("/slug/{slug}/districts")
    @Operation(summary = "Get all districts in a province by slug", description = "Returns paginated districts belonging to the given province slug.")
    public ResponseEntity<PagedResponse<com.knownepal.geography.dto.response.DistrictResponse>> getDistrictsBySlug(
            @PathVariable String slug,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(districtService.findByProvinceSlug(slug, pageable));
    }

    @PostMapping
    @Operation(summary = "Create a new province")
    public ResponseEntity<ProvinceResponse> create(@Valid @RequestBody ProvinceRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(provinceService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing province")
    public ResponseEntity<ProvinceResponse> update(@PathVariable Long id, @Valid @RequestBody ProvinceRequest request) {
        return ResponseEntity.ok(provinceService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a province")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        provinceService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

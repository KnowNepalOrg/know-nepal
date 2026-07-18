package com.knownepal.geography.controller;

import com.knownepal.geography.dto.request.EmergencyContactRequest;
import com.knownepal.geography.dto.response.EmergencyContactResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.model.EmergencyContactType;
import com.knownepal.geography.service.EmergencyContactService;
import com.knownepal.geography.specification.EmergencyContactSpecification;
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
@RequestMapping(Constants.EMERGENCY_CONTACTS)
@RequiredArgsConstructor
@Tag(name = "Emergency Contact", description = "Nepal Emergency Contact Management API — paginated list endpoints, national contacts, CRUD operations")
public class EmergencyContactController {

    private final EmergencyContactService emergencyContactService;

    @GetMapping
    @Operation(summary = "Get all emergency contacts with optional filtering", description = "Returns a paginated list of emergency contacts. Supports name, type, isNational, districtId, and provinceId filtering.")
    public ResponseEntity<PagedResponse<EmergencyContactResponse>> getAll(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) EmergencyContactType type,
            @RequestParam(required = false) Boolean isNational,
            @RequestParam(required = false) Long districtId,
            @RequestParam(required = false) Long provinceId,
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(emergencyContactService.findAll(
                EmergencyContactSpecification.build(name, type, isNational, districtId, provinceId), pageable));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get emergency contact by ID")
    public ResponseEntity<EmergencyContactResponse> getById(@PathVariable Long id) {
        return ResponseEntity.ok(emergencyContactService.findById(id));
    }

    @GetMapping("/slug/{slug}")
    @Operation(summary = "Get emergency contact by slug")
    public ResponseEntity<EmergencyContactResponse> getBySlug(@PathVariable String slug) {
        return ResponseEntity.ok(emergencyContactService.findBySlug(slug));
    }

    @GetMapping("/national")
    @Operation(summary = "Get all national emergency contacts", description = "Returns paginated emergency contacts that are marked as national (isNational=true).")
    public ResponseEntity<PagedResponse<EmergencyContactResponse>> getNational(
            @PageableDefault(size = Constants.DEFAULT_PAGE_SIZE, sort = "id") Pageable pageable) {
        return ResponseEntity.ok(emergencyContactService.findNational(pageable));
    }

    @PostMapping
    @Operation(summary = "Create a new emergency contact")
    public ResponseEntity<EmergencyContactResponse> create(@Valid @RequestBody EmergencyContactRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(emergencyContactService.create(request));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing emergency contact")
    public ResponseEntity<EmergencyContactResponse> update(
            @PathVariable Long id, @Valid @RequestBody EmergencyContactRequest request) {
        return ResponseEntity.ok(emergencyContactService.update(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an emergency contact")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        emergencyContactService.delete(id);
        return ResponseEntity.noContent().build();
    }
}

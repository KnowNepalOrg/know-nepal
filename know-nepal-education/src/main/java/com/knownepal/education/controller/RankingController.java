package com.knownepal.education.controller;

import com.knownepal.education.dto.request.RankingRequest;
import com.knownepal.education.dto.response.ApiResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.RankingResponse;
import com.knownepal.education.model.RankingSource;
import com.knownepal.education.service.RankingService;
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
@RequestMapping("/api/v1/rankings")
@Tag(name = "Rankings", description = "Institution ranking management")
@RequiredArgsConstructor
public class RankingController {

    private final RankingService service;

    @GetMapping("/{id}")
    @Operation(summary = "Get ranking by id")
    public ResponseEntity<ApiResponse<RankingResponse>> getById(@PathVariable Long id) {
        return ResponseEntity.ok(ApiResponse.ok(service.getById(id)));
    }

    @GetMapping
    @Operation(summary = "List rankings with filters and pagination")
    public ResponseEntity<ApiResponse<PagedResponse<RankingResponse>>> getAll(
            @RequestParam(required = false) String institutionType,
            @RequestParam(required = false) Long institutionId,
            @RequestParam(required = false) RankingSource source,
            @RequestParam(required = false) String year,
            @PageableDefault(size = 20, page = 0) Pageable pageable) {

        PagedResponse<RankingResponse> result = service.getAll(
                institutionType, institutionId, source, year,
                pageable.getPageNumber(), pageable.getPageSize());
        return ResponseEntity.ok(ApiResponse.ok(result));
    }

    @PostMapping
    @Operation(summary = "Create a new ranking")
    public ResponseEntity<ApiResponse<RankingResponse>> create(@Valid @RequestBody RankingRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(ApiResponse.ok(service.create(request)));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing ranking by id")
    public ResponseEntity<ApiResponse<RankingResponse>> update(@PathVariable Long id,
                                                                @Valid @RequestBody RankingRequest request) {
        return ResponseEntity.ok(ApiResponse.ok(service.update(id, request)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a ranking by id")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}

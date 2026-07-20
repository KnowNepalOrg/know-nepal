package com.knownepal.destinations.controller;

import com.knownepal.destinations.dto.response.ApiResponse;
import com.knownepal.destinations.dto.response.DestinationCategoryResponse;
import com.knownepal.destinations.dto.response.TagResponse;
import com.knownepal.destinations.dto.response.TouristDestinationResponse;
import com.knownepal.destinations.dto.response.TrekkingRouteResponse;
import com.knownepal.destinations.service.DestinationCategoryService;
import com.knownepal.destinations.service.DestinationTagService;
import com.knownepal.destinations.service.TouristDestinationService;
import com.knownepal.destinations.service.TrekkingRouteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/search")
@RequiredArgsConstructor
@Tag(name = "Search", description = "Full-text search across all entity types")
public class SearchController {

    private final TouristDestinationService destinationService;
    private final TrekkingRouteService routeService;
    private final DestinationCategoryService categoryService;
    private final DestinationTagService tagService;

    @GetMapping
    @Operation(summary = "Search across all entity types")
    public ResponseEntity<ApiResponse<Map<String, Object>>> search(
            @RequestParam String q,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        var pageable = PageRequest.of(page, size);
        Map<String, Object> results = new HashMap<>();
        results.put("destinations", destinationService.search(q, pageable));
        results.put("routes", routeService.search(q, pageable));
        results.put("query", q);
        return ResponseEntity.ok(ApiResponse.success(results));
    }
}

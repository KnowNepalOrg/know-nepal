package com.knownepal.geography.controller;

import com.knownepal.geography.dto.response.SearchResponse;
import com.knownepal.geography.service.SearchService;
import com.knownepal.geography.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.SEARCH)
@RequiredArgsConstructor
@Tag(name = "Search", description = "Global Search API — search across all geography entities")
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    @Operation(summary = "Global search across provinces, districts, municipalities, wards, and emergency contacts")
    public ResponseEntity<SearchResponse> search(@RequestParam String q) {
        return ResponseEntity.ok(searchService.search(q));
    }
}

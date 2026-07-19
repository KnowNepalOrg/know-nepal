package com.knownepal.education.controller;

import com.knownepal.education.dto.response.SearchResponse;
import com.knownepal.education.service.SearchService;
import com.knownepal.education.util.Constants;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(Constants.SEARCH)
@RequiredArgsConstructor
@Tag(name = "Search", description = "Global Search API — search across all education entities")
public class SearchController {

    private final SearchService searchService;

    @GetMapping
    @Operation(summary = "Global search across schools, colleges, universities, programs, exam boards, scholarships, entrance exams, teachers, calendars, fees, and rankings")
    public ResponseEntity<SearchResponse> search(@RequestParam String q) {
        return ResponseEntity.ok(searchService.search(q));
    }
}

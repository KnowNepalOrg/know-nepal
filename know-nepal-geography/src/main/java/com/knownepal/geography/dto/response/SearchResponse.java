package com.knownepal.geography.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchResponse {

    private String query;
    private List<SearchResult> provinces;
    private List<SearchResult> districts;
    private List<SearchResult> municipalities;
    private List<SearchResult> wards;
    private List<SearchResult> emergencyContacts;
    private int totalResults;
}

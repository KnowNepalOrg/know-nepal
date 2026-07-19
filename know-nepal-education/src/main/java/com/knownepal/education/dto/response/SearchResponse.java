package com.knownepal.education.dto.response;

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
    private List<SearchResult> schools;
    private List<SearchResult> colleges;
    private List<SearchResult> universities;
    private List<SearchResult> programs;
    private List<SearchResult> examBoards;
    private List<SearchResult> scholarships;
    private List<SearchResult> entranceExams;
    private List<SearchResult> teacherProfiles;
    private List<SearchResult> academicCalendars;
    private List<SearchResult> feeBreakdowns;
    private List<SearchResult> rankings;
    private int totalResults;
}

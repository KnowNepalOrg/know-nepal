package com.knownepal.education.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SearchResult {

    private Long id;
    private String name;
    private String nameNepali;
    private String slug;
    private String entityType;
    private String parentName;
    private String detail;
}

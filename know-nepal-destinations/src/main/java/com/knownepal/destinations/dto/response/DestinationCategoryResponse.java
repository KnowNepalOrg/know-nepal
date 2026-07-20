package com.knownepal.destinations.dto.response;

import lombok.Data;

@Data
public class DestinationCategoryResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private String icon;
    private Integer displayOrder;
}

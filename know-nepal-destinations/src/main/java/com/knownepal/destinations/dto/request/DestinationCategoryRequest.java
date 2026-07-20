package com.knownepal.destinations.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DestinationCategoryRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;
    private String icon;
    private Integer displayOrder;
}

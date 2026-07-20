package com.knownepal.destinations.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class DestinationHighlightRequest {

    @NotBlank(message = "Title is required")
    private String title;

    private String description;
    private Integer displayOrder;
}

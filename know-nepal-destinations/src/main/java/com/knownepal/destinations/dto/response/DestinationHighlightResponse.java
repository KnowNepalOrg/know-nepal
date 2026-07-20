package com.knownepal.destinations.dto.response;

import lombok.Data;

@Data
public class DestinationHighlightResponse {

    private Long id;
    private Long destinationId;
    private String title;
    private String description;
    private Integer displayOrder;
}

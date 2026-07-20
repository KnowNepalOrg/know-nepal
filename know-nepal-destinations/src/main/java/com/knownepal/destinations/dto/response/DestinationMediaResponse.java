package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.MediaType;
import lombok.Data;

@Data
public class DestinationMediaResponse {

    private Long id;
    private Long destinationId;
    private String url;
    private String caption;
    private MediaType mediaType;
    private Integer displayOrder;
    private Boolean isPrimary;
}

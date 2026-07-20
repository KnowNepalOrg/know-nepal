package com.knownepal.destinations.dto.request;

import com.knownepal.destinations.model.MediaType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DestinationMediaRequest {

    @NotBlank(message = "URL is required")
    private String url;

    private String caption;

    @NotNull(message = "Media type is required")
    private MediaType mediaType;

    private Integer displayOrder;
    private Boolean isPrimary;
}

package com.knownepal.destinations.dto.request;

import com.knownepal.destinations.model.TagType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DestinationTagRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotNull(message = "Tag type is required")
    private TagType tagType;
}

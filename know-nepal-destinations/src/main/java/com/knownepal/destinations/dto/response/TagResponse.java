package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.TagType;
import lombok.Data;

@Data
public class TagResponse {

    private Long id;
    private String slug;
    private String name;
    private TagType tagType;
}

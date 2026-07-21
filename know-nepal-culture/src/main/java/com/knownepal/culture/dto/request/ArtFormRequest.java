package com.knownepal.culture.dto.request;

import com.knownepal.culture.model.ArtType;
import com.knownepal.culture.model.RegionType;
import com.knownepal.culture.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ArtFormRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Art type is required")
    @ValidEnum(enumClass = ArtType.class, message = "must be a valid art type")
    private String artType;

    private Long ethnicGroupId;

    @ValidEnum(enumClass = RegionType.class, message = "must be a valid region type")
    private String regionType;

    private String province;

    private String historicalSignificance;

    private String techniques;

    private String materials;

    private String significance;

    private String contemporaryRelevance;

    private Boolean isIntangibleHeritage;
}

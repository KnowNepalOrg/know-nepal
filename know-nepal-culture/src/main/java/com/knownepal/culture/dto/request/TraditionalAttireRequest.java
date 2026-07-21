package com.knownepal.culture.dto.request;

import com.knownepal.culture.model.AttireOccasion;
import com.knownepal.culture.model.GenderType;
import com.knownepal.culture.model.RegionType;
import com.knownepal.culture.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TraditionalAttireRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Gender type is required")
    @ValidEnum(enumClass = GenderType.class, message = "must be a valid gender type")
    private String genderType;

    @NotBlank(message = "Attire occasion is required")
    @ValidEnum(enumClass = AttireOccasion.class, message = "must be a valid attire occasion")
    private String attireOccasion;

    private Long ethnicGroupId;

    @ValidEnum(enumClass = RegionType.class, message = "must be a valid region type")
    private String regionType;

    private String province;

    private String fabricMaterial;

    private String colors;

    private String patterns;

    private String significance;

    private String wearingOccasion;

    private String historicalOrigin;

    private String regionalVariations;
}

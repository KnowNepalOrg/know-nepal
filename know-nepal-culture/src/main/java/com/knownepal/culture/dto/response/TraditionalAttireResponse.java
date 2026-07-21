package com.knownepal.culture.dto.response;

import lombok.Data;

@Data
public class TraditionalAttireResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private String genderType;
    private String attireOccasion;
    private String ethnicGroupName;
    private Long ethnicGroupId;
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

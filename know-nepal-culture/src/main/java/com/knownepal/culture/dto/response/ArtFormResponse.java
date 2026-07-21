package com.knownepal.culture.dto.response;

import lombok.Data;

@Data
public class ArtFormResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private String artType;
    private String ethnicGroupName;
    private Long ethnicGroupId;
    private String regionType;
    private String province;
    private String historicalSignificance;
    private String techniques;
    private String materials;
    private String significance;
    private String contemporaryRelevance;
    private Boolean isIntangibleHeritage;
}

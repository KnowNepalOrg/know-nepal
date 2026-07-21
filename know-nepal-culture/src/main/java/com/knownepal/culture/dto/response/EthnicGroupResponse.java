package com.knownepal.culture.dto.response;

import lombok.Data;

@Data
public class EthnicGroupResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private Long populationEstimate;
    private String languageName;
    private Long languageId;
    private String regionType;
    private String province;
    private String subRegion;
    private String traditionalOccupation;
    private String socialStructure;
    private String religion;
    private String customs;
    private String rituals;
    private String festivals;
    private Boolean isIndigenous;
    private Boolean isDeprived;
    private String origin;
    private String migrationHistory;
}

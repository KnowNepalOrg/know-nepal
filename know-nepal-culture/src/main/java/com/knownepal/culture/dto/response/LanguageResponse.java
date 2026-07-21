package com.knownepal.culture.dto.response;

import lombok.Data;

@Data
public class LanguageResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private String languageFamily;
    private String languageStatus;
    private Long speakersCount;
    private String script;
    private String writingSystem;
    private String dialects;
    private Boolean isOfficial;
    private Boolean isLinguaFranca;
    private String regionType;
    private String province;
    private String originHistory;
    private String culturalSignificance;
    private String endangeredDetails;
    private String preservationEfforts;
}

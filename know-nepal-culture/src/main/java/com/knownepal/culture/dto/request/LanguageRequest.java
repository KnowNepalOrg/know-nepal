package com.knownepal.culture.dto.request;

import com.knownepal.culture.model.LanguageFamily;
import com.knownepal.culture.model.LanguageStatus;
import com.knownepal.culture.model.RegionType;
import com.knownepal.culture.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LanguageRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Language family is required")
    @ValidEnum(enumClass = LanguageFamily.class, message = "must be a valid language family")
    private String languageFamily;

    @NotNull(message = "Language status is required")
    @ValidEnum(enumClass = LanguageStatus.class, message = "must be a valid language status")
    private String languageStatus;

    private Long speakersCount;

    private String script;

    private String writingSystem;

    private String dialects;

    private Boolean isOfficial;

    private Boolean isLinguaFranca;

    @ValidEnum(enumClass = RegionType.class, message = "must be a valid region type")
    private String regionType;

    private String province;

    private String originHistory;

    private String culturalSignificance;

    private String endangeredDetails;

    private String preservationEfforts;
}

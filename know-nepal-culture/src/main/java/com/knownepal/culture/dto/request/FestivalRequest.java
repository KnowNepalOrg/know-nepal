package com.knownepal.culture.dto.request;

import com.knownepal.culture.model.CultureSeason;
import com.knownepal.culture.model.FestivalType;
import com.knownepal.culture.model.RegionType;
import com.knownepal.culture.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FestivalRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Festival type is required")
    @ValidEnum(enumClass = FestivalType.class, message = "must be a valid festival type")
    private String festivalType;

    @NotBlank(message = "Culture season is required")
    @ValidEnum(enumClass = CultureSeason.class, message = "must be a valid culture season")
    private String cultureSeason;

    private String month;

    private String day;

    private Integer durationDays;

    @ValidEnum(enumClass = RegionType.class, message = "must be a valid region type")
    private String regionType;

    private Boolean isNationalHoliday;

    private Boolean isPublicHoliday;

    private String significance;

    private String rituals;

    private String modernCelebrations;

    private String ethnicGroupsInvolved;

    private String province;

    private String district;

    private Boolean isPopular;

    private Boolean isFeatured;
}

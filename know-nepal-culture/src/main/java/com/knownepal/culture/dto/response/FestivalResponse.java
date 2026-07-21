package com.knownepal.culture.dto.response;

import lombok.Data;

@Data
public class FestivalResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private String festivalType;
    private String cultureSeason;
    private String month;
    private String day;
    private Integer durationDays;
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

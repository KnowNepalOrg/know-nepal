package com.knownepal.culture.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "festivals")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Festival extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "festival_type", nullable = false, length = 20)
    private FestivalType festivalType;

    @Enumerated(EnumType.STRING)
    @Column(name = "culture_season", nullable = false, length = 20)
    private CultureSeason cultureSeason;

    @Column(length = 50)
    private String month;

    @Column(length = 50)
    private String day;

    @Column(name = "duration_days")
    private Integer durationDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "region_type", length = 20)
    private RegionType regionType;

    @Column(name = "is_national_holiday")
    private Boolean isNationalHoliday;

    @Column(name = "is_public_holiday")
    private Boolean isPublicHoliday;

    @Column(columnDefinition = "TEXT")
    private String significance;

    @Column(columnDefinition = "TEXT")
    private String rituals;

    @Column(name = "modern_celebrations", columnDefinition = "TEXT")
    private String modernCelebrations;

    @Column(name = "ethnic_groups_involved", columnDefinition = "TEXT")
    private String ethnicGroupsInvolved;

    @Column(length = 100)
    private String province;

    @Column(length = 100)
    private String district;

    @Column(name = "is_popular")
    private Boolean isPopular;

    @Column(name = "is_featured")
    private Boolean isFeatured;
}

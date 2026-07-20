package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tourist_destinations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TouristDestination extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "destination_type", nullable = false, length = 30)
    private DestinationType destinationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private DestinationCategory category;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "province_name", length = 100)
    private String provinceName;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_name", length = 100)
    private String districtName;

    @Column(name = "municipality_id")
    private Long municipalityId;

    @Column(name = "municipality_name", length = 150)
    private String municipalityName;

    @Column(precision = 10, scale = 7)
    private BigDecimal latitude;

    @Column(precision = 10, scale = 7)
    private BigDecimal longitude;

    @Column(name = "altitude_meters")
    private Integer altitudeMeters;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", length = 20)
    private DifficultyLevel difficultyLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "best_season", length = 20)
    private BestSeason bestSeason;

    @Column(name = "entry_fee_npr", precision = 10, scale = 2)
    private BigDecimal entryFeeNpr;

    @Column(name = "visit_duration", length = 50)
    private String visitDuration;

    @Column(name = "is_popular")
    @Builder.Default
    private Boolean isPopular = false;

    @Column(name = "is_featured")
    @Builder.Default
    private Boolean isFeatured = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "destination_tag_mappings",
            joinColumns = @JoinColumn(name = "destination_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id")
    )
    @Builder.Default
    private List<DestinationTag> tags = new ArrayList<>();

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<DestinationHighlight> highlights = new ArrayList<>();

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<DestinationReview> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<DestinationMedia> media = new ArrayList<>();

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<DestinationFee> fees = new ArrayList<>();
}

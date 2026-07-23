package com.knownepal.wildlife.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "lakes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Lake extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "lake_type", nullable = false, length = 20)
    private LakeType lakeType;

    @Column(name = "district", length = 150)
    private String district;

    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "elevation_m")
    private Integer elevationM;

    @Column(name = "area_sq_km")
    private Double areaSqKm;

    @Column(name = "max_depth_m")
    private Integer maxDepthM;

    @Column(name = "length_km")
    private Double lengthKm;

    @Column(name = "width_km")
    private Double widthKm;

    @Column(name = "municipality", length = 150)
    private String municipality;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "how_to_reach", columnDefinition = "TEXT")
    private String howToReach;

    @Column(name = "best_season", length = 50)
    private String bestSeason;

    @Column(name = "entry_fee_npr")
    private Integer entryFeeNpr;

    @Column(name = "contact_info", columnDefinition = "TEXT")
    private String contactInfo;

    @Column(name = "image_url", length = 500)
    private String imageUrl;

    @Column(name = "photos", columnDefinition = "TEXT")
    private String photos;

    @Column(name = "notable_features", columnDefinition = "TEXT")
    private String notableFeatures;

    @Column(name = "is_featured")
    private Boolean isFeatured;
}

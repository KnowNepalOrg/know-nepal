package com.knownepal.wildlife.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "national_parks")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NationalPark extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "area_type", nullable = false, length = 30)
    private ProtectedAreaType areaType;

    @Column(name = "district", length = 150)
    private String district;

    @Column(name = "province", length = 100)
    private String province;

    @Column(name = "area_sq_km")
    private Double areaSqKm;

    @Column(name = "buffer_zone_sq_km")
    private Double bufferZoneSqKm;

    @Column(name = "established_year")
    private Integer establishedYear;

    @Column(name = "elevation_min_m")
    private Integer elevationMinM;

    @Column(name = "elevation_max_m")
    private Integer elevationMaxM;

    @Column(name = "key_species", columnDefinition = "TEXT")
    private String keySpecies;

    @Column(name = "notable_features", columnDefinition = "TEXT")
    private String notableFeatures;

    @Column(name = "visitor_count")
    private Integer visitorCount;

    @Column(name = "is_featured")
    private Boolean isFeatured;
}

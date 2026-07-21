package com.knownepal.culture.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "traditional_attires")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TraditionalAttire extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender_type", nullable = false, length = 20)
    private GenderType genderType;

    @Enumerated(EnumType.STRING)
    @Column(name = "attire_occasion", nullable = false, length = 20)
    private AttireOccasion attireOccasion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ethnic_group_id")
    private EthnicGroup ethnicGroup;

    @Enumerated(EnumType.STRING)
    @Column(name = "region_type", length = 20)
    private RegionType regionType;

    @Column(length = 100)
    private String province;

    @Column(name = "fabric_material", length = 200)
    private String fabricMaterial;

    @Column(columnDefinition = "TEXT")
    private String colors;

    @Column(columnDefinition = "TEXT")
    private String patterns;

    @Column(columnDefinition = "TEXT")
    private String significance;

    @Column(name = "wearing_occasion", columnDefinition = "TEXT")
    private String wearingOccasion;

    @Column(name = "historical_origin", columnDefinition = "TEXT")
    private String historicalOrigin;

    @Column(name = "regional_variations", columnDefinition = "TEXT")
    private String regionalVariations;
}

package com.knownepal.culture.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "ethnic_groups")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EthnicGroup extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "population_estimate")
    private Long populationEstimate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id")
    private Language language;

    @Enumerated(EnumType.STRING)
    @Column(name = "region_type", length = 20)
    private RegionType regionType;

    @Column(length = 100)
    private String province;

    @Column(name = "sub_region", length = 150)
    private String subRegion;

    @Column(name = "traditional_occupation", length = 200)
    private String traditionalOccupation;

    @Column(name = "social_structure", columnDefinition = "TEXT")
    private String socialStructure;

    @Column(length = 100)
    private String religion;

    @Column(columnDefinition = "TEXT")
    private String customs;

    @Column(columnDefinition = "TEXT")
    private String rituals;

    @Column(columnDefinition = "TEXT")
    private String festivals;

    @Column(name = "is_indigenous")
    private Boolean isIndigenous;

    @Column(name = "is_deprived")
    private Boolean isDeprived;

    @Column(columnDefinition = "TEXT")
    private String origin;

    @Column(name = "migration_history", columnDefinition = "TEXT")
    private String migrationHistory;
}

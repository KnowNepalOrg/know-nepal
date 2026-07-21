package com.knownepal.culture.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "art_forms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArtForm extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "art_type", nullable = false, length = 20)
    private ArtType artType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ethnic_group_id")
    private EthnicGroup ethnicGroup;

    @Enumerated(EnumType.STRING)
    @Column(name = "region_type", length = 20)
    private RegionType regionType;

    @Column(length = 100)
    private String province;

    @Column(name = "historical_significance", columnDefinition = "TEXT")
    private String historicalSignificance;

    @Column(columnDefinition = "TEXT")
    private String techniques;

    @Column(columnDefinition = "TEXT")
    private String materials;

    @Column(columnDefinition = "TEXT")
    private String significance;

    @Column(name = "contemporary_relevance", columnDefinition = "TEXT")
    private String contemporaryRelevance;

    @Column(name = "is_intangible_heritage")
    private Boolean isIntangibleHeritage;
}

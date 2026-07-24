package com.knownepal.history.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dynasties")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Dynasty extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "era_id", nullable = false)
    private HistoricalEra era;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "founder_id")
    private HistoricalFigure founder;

    @Column(name = "start_year")
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "capital", length = 150)
    private String capital;

    @Column(name = "key_achievements", columnDefinition = "TEXT")
    private String keyAchievements;

    @Column(name = "number_of_rulers")
    private Integer numberOfRulers;

    @Column(name = "is_featured")
    private Boolean isFeatured;
}

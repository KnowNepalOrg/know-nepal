package com.knownepal.history.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historical_figures")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricalFigure extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "figure_type", nullable = false, length = 20)
    private FigureType figureType;

    @Column(name = "birth_year")
    private Integer birthYear;

    @Column(name = "death_year")
    private Integer deathYear;

    @Column(name = "birth_place", length = 200)
    private String birthPlace;

    @Column(name = "known_for", columnDefinition = "TEXT")
    private String knownFor;

    @Column(name = "key_achievements", columnDefinition = "TEXT")
    private String keyAchievements;

    @Column(name = "dynasty_affiliation", length = 150)
    private String dynastyAffiliation;

    @Column(name = "era_name", length = 150)
    private String eraName;

    @Column(name = "is_featured")
    private Boolean isFeatured;
}

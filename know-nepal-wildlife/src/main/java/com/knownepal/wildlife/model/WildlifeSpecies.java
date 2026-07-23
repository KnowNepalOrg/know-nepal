package com.knownepal.wildlife.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "wildlife_species")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WildlifeSpecies extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "scientific_name", length = 200)
    private String scientificName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "class_type", nullable = false, length = 20)
    private ClassType classType;

    @Enumerated(EnumType.STRING)
    @Column(name = "conservation_status", nullable = false, length = 30)
    private ConservationStatus conservationStatus;

    @Enumerated(EnumType.STRING)
    @Column(name = "nepal_status", length = 20)
    private NepalStatus nepalStatus;

    @Column(name = "habitat", length = 200)
    private String habitat;

    @Column(name = "elevation_range", length = 100)
    private String elevationRange;

    @Column(name = "estimated_population", length = 100)
    private String estimatedPopulation;

    @Column(name = "is_endemic")
    private Boolean isEndemic;

    @Column(name = "is_featured")
    private Boolean isFeatured;

    @Column(name = "fun_facts", columnDefinition = "TEXT")
    private String funFacts;
}

package com.knownepal.wildlife.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "flora_species")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FloraSpecies extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "scientific_name", length = 200)
    private String scientificName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "plant_type", length = 100)
    private String plantType;

    @Column(name = "family_name", length = 100)
    private String familyName;

    @Column(name = "habitat", length = 200)
    private String habitat;

    @Column(name = "elevation_range", length = 100)
    private String elevationRange;

    @Column(name = "is_endemic")
    private Boolean isEndemic;

    @Column(name = "is_medicinal")
    private Boolean isMedicinal;

    @Column(name = "medicinal_uses", columnDefinition = "TEXT")
    private String medicinalUses;

    @Column(name = "conservation_status", length = 30)
    private String conservationStatus;

    @Column(name = "is_featured")
    private Boolean isFeatured;

    @Column(name = "fun_facts", columnDefinition = "TEXT")
    private String funFacts;
}

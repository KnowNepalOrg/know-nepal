package com.knownepal.history.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historical_eras")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricalEra extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "start_year", nullable = false)
    private Integer startYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "key_characteristics", columnDefinition = "TEXT")
    private String keyCharacteristics;

    @Column(name = "is_featured")
    private Boolean isFeatured;
}

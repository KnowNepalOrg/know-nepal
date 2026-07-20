package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trekking_routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TrekkingRoute extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", nullable = false, length = 20)
    private DifficultyLevel difficultyLevel;

    @Column(name = "distance_km", precision = 8, scale = 2)
    private BigDecimal distanceKm;

    @Column(name = "duration_days")
    private Integer durationDays;

    @Column(name = "max_altitude_meters")
    private Integer maxAltitudeMeters;

    @Enumerated(EnumType.STRING)
    @Column(name = "best_season", length = 20)
    private BestSeason bestSeason;

    @Column(name = "is_popular")
    @Builder.Default
    private Boolean isPopular = false;

    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<RouteDestination> routeDestinations = new ArrayList<>();
}

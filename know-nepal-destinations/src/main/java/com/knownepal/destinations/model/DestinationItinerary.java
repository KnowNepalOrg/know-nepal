package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "destination_itineraries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationItinerary extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 200)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name = "duration_days", nullable = false)
    private Integer durationDays;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty_level", length = 20)
    private DifficultyLevel difficultyLevel;

    @Enumerated(EnumType.STRING)
    @Column(name = "best_season", length = 20)
    private BestSeason bestSeason;

    @Column(name = "is_popular")
    @Builder.Default
    private Boolean isPopular = false;

    @OneToMany(mappedBy = "itinerary", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("dayNumber ASC")
    @Builder.Default
    private List<ItineraryDay> days = new ArrayList<>();
}

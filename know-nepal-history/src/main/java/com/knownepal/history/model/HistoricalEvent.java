package com.knownepal.history.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "historical_events")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HistoricalEvent extends Base {

    @Column(nullable = false, unique = true, length = 150)
    private String slug;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false, length = 20)
    private EventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "era_id", nullable = false)
    private HistoricalEra era;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dynasty_id")
    private Dynasty dynasty;

    @Column(name = "event_year", nullable = false)
    private Integer eventYear;

    @Column(name = "end_year")
    private Integer endYear;

    @Column(name = "location", length = 200)
    private String location;

    @Column(name = "significance", columnDefinition = "TEXT")
    private String significance;

    @Column(name = "key_figures_involved", columnDefinition = "TEXT")
    private String keyFiguresInvolved;

    @Column(name = "outcome", columnDefinition = "TEXT")
    private String outcome;

    @Column(name = "is_featured")
    private Boolean isFeatured;
}

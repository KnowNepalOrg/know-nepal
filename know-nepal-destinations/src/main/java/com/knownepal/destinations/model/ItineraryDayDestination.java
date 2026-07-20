package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "itinerary_day_destinations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItineraryDayDestination extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "itinerary_day_id", nullable = false)
    private ItineraryDay itineraryDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private TouristDestination destination;

    @Column(name = "sequence_order", nullable = false)
    private Integer sequenceOrder;

    @Column(length = 500)
    private String notes;
}

package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "nearby_destinations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"destination_id", "nearby_destination_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NearbyDestination extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private TouristDestination destination;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "nearby_destination_id", nullable = false)
    private TouristDestination nearbyDestination;

    @Column(name = "distance_km", precision = 8, scale = 2)
    private BigDecimal distanceKm;

    @Column(name = "travel_time_minutes")
    private Integer travelTimeMinutes;

    @Enumerated(EnumType.STRING)
    @Column(name = "travel_mode", length = 20)
    private TravelMode travelMode;
}

package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "route_destinations",
        uniqueConstraints = @UniqueConstraint(columnNames = {"route_id", "destination_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RouteDestination extends Base {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "route_id", nullable = false)
    private TrekkingRoute route;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private TouristDestination destination;

    @Column(name = "sequence_order", nullable = false)
    private Integer sequenceOrder;

    @Column(name = "is_overnight_stop")
    @Builder.Default
    private Boolean isOvernightStop = false;
}

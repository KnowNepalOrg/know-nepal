package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "destination_tag_mappings",
        uniqueConstraints = @UniqueConstraint(columnNames = {"destination_id", "tag_id"}))
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationTagMapping extends Base {

    @Column(name = "destination_id", nullable = false)
    private Long destinationId;

    @Column(name = "tag_id", nullable = false)
    private Long tagId;
}

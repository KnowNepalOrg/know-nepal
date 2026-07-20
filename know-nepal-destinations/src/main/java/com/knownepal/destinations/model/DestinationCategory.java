package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "destination_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationCategory extends Base {

    @Column(nullable = false, unique = true, length = 100)
    private String slug;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(length = 50)
    private String icon;

    @Column(name = "display_order")
    private Integer displayOrder;
}

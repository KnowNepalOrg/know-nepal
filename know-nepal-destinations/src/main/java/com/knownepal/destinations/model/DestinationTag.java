package com.knownepal.destinations.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "destination_tags")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DestinationTag extends Base {

    @Column(nullable = false, unique = true, length = 100)
    private String slug;

    @Column(nullable = false, length = 100)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "tag_type", nullable = false, length = 20)
    private TagType tagType;
}

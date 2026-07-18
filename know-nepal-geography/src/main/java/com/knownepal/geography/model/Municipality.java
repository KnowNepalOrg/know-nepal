package com.knownepal.geography.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "municipalities")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Municipality extends Base {

    @Column(name = "name", nullable = false, unique = true, length = 150)
    private String name;

    @Column(name = "name_nepali", length = 150)
    private String nameNepali;

    @Column(name = "code", nullable = false, unique = true, length = 10)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 30)
    private MunicipalityType type;

    @Column(name = "area")
    private Double area;

    @Column(name = "population")
    private Long population;

    @Column(name = "ward_count")
    private Integer wardCount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id", nullable = false)
    private District district;

    @Column(name = "slug", nullable = false, unique = true, length = 150)
    private String slug;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "elevation")
    private Double elevation;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "website_url", length = 255)
    private String websiteUrl;

    @Column(name = "contact_phone", length = 50)
    private String contactPhone;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

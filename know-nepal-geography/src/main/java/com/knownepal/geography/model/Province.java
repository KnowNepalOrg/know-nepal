package com.knownepal.geography.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "provinces")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Province extends Base {

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "name_nepali", length = 100)
    private String nameNepali;

    @Column(name = "code", nullable = false, unique = true, length = 10)
    private String code;

    @Column(name = "area")
    private Double area;

    @Column(name = "population")
    private Long population;

    @Column(name = "capital", length = 100)
    private String capital;

    @Column(name = "number_of_districts")
    private Integer numberOfDistricts;

    @Column(name = "slug", nullable = false, unique = true, length = 150)
    private String slug;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

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

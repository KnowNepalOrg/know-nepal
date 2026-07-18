package com.knownepal.geography.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "emergency_contacts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmergencyContact extends Base {

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "name_nepali", length = 200)
    private String nameNepali;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 30)
    private EmergencyContactType type;

    @Column(name = "phone", nullable = false, length = 50)
    private String phone;

    @Column(name = "alternate_phone", length = 50)
    private String alternatePhone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "is_national", nullable = false)
    @Builder.Default
    private Boolean isNational = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "district_id")
    private District district;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "province_id")
    private Province province;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "slug", nullable = false, unique = true, length = 200)
    private String slug;

    @Column(name = "contact_person", length = 200)
    private String contactPerson;

    @Column(name = "available_hours", length = 200)
    private String availableHours;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

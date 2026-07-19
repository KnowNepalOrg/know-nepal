package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "scholarships")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Scholarship extends Base {

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "name_nepali", length = 200)
    private String nameNepali;

    @Column(name = "slug", nullable = false, unique = true, length = 250)
    private String slug;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 30)
    private ScholarshipType type;

    @Column(name = "provider", length = 200)
    private String provider;

    @Column(name = "amount", length = 200)
    private String amount;

    @Column(name = "eligibility", columnDefinition = "TEXT")
    private String eligibility;

    @Column(name = "deadline", length = 50)
    private String deadline;

    @Column(name = "application_url", length = 255)
    private String applicationUrl;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "total_slots")
    private Integer totalSlots;

    @Column(name = "is_renewable")
    private Boolean isRenewable;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "province_name", length = 100)
    private String provinceName;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_name", length = 100)
    private String districtName;

    @Column(name = "contact_phone", length = 50)
    private String contactPhone;

    @Column(name = "contact_email", length = 100)
    private String contactEmail;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

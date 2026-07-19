package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "schools")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class School extends Base {

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "name_nepali", length = 200)
    private String nameNepali;

    @Column(name = "slug", nullable = false, unique = true, length = 250)
    private String slug;

    @Column(name = "code", nullable = false, unique = true, length = 20)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false, length = 20)
    private SchoolType type;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false, length = 20)
    private EducationLevel level;

    @Column(name = "established_year")
    private Integer establishedYear;

    @Column(name = "affiliation", length = 200)
    private String affiliation;

    @Column(name = "student_count")
    private Integer studentCount;

    @Column(name = "teacher_count")
    private Integer teacherCount;

    @Column(name = "area_sq_km")
    private Double areaSqKm;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "elevation")
    private Double elevation;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "province_name", length = 100)
    private String provinceName;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_name", length = 100)
    private String districtName;

    @Column(name = "municipality_id")
    private Long municipalityId;

    @Column(name = "municipality_name", length = 100)
    private String municipalityName;

    @Column(name = "ward_id")
    private Long wardId;

    @Column(name = "ward_name", length = 100)
    private String wardName;

    @Column(name = "address", length = 500)
    private String address;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exam_boards")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExamBoard extends Base {

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "name_nepali", length = 200)
    private String nameNepali;

    @Column(name = "slug", nullable = false, unique = true, length = 250)
    private String slug;

    @Column(name = "code", nullable = false, unique = true, length = 20)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "category", nullable = false, length = 30)
    private BoardCategory category;

    @Column(name = "established_year")
    private Integer establishedYear;

    @Column(name = "headquarters", length = 200)
    private String headquarters;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "grading_system", columnDefinition = "TEXT")
    private String gradingSystem;

    @Column(name = "province_id")
    private Long provinceId;

    @Column(name = "province_name", length = 100)
    private String provinceName;

    @Column(name = "district_id")
    private Long districtId;

    @Column(name = "district_name", length = 100)
    private String districtName;

    @Column(name = "phone", length = 50)
    private String phone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

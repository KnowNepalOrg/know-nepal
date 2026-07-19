package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "teacher_profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TeacherProfile extends Base {

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "name_nepali", length = 200)
    private String nameNepali;

    @Column(name = "slug", nullable = false, unique = true, length = 250)
    private String slug;

    @Enumerated(EnumType.STRING)
    @Column(name = "qualification_level", nullable = false, length = 30)
    private QualificationLevel qualificationLevel;

    @Column(name = "qualification_detail", length = 200)
    private String qualificationDetail;

    @Column(name = "specialization", length = 200)
    private String specialization;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "institution_type", nullable = false, length = 30)
    private String institutionType;

    @Column(name = "institution_id", nullable = false)
    private Long institutionId;

    @Column(name = "institution_name", length = 200)
    private String institutionName;

    @Column(name = "department", length = 200)
    private String department;

    @Column(name = "designation", length = 100)
    private String designation;

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

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

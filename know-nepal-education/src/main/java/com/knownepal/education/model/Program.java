package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "programs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Program extends Base {

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "name_nepali", length = 200)
    private String nameNepali;

    @Column(name = "slug", nullable = false, unique = true, length = 250)
    private String slug;

    @Column(name = "code", nullable = false, unique = true, length = 20)
    private String code;

    @Enumerated(EnumType.STRING)
    @Column(name = "level", nullable = false, length = 20)
    private ProgramLevel level;

    @Column(name = "faculty", length = 100)
    private String faculty;

    @Column(name = "duration_years")
    private Integer durationYears;

    @Column(name = "total_seats")
    private Integer totalSeats;

    @Column(name = "fee_structure", columnDefinition = "TEXT")
    private String feeStructure;

    @Column(name = "eligibility", columnDefinition = "TEXT")
    private String eligibility;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "institution_type", nullable = false, length = 20)
    private InstitutionType institutionType;

    @Column(name = "institution_id", nullable = false)
    private Long institutionId;

    @Column(name = "institution_name", length = 200)
    private String institutionName;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

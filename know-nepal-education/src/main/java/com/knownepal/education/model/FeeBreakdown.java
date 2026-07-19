package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "fee_breakdowns")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeeBreakdown extends Base {

    @Column(name = "program_id")
    private Long programId;

    @Column(name = "program_name", length = 200)
    private String programName;

    @Column(name = "institution_type", nullable = false, length = 30)
    private String institutionType;

    @Column(name = "institution_id", nullable = false)
    private Long institutionId;

    @Column(name = "institution_name", length = 200)
    private String institutionName;

    @Enumerated(EnumType.STRING)
    @Column(name = "component", nullable = false, length = 30)
    private FeeComponent component;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "currency", length = 10)
    private String currency;

    @Column(name = "semester", length = 50)
    private String semester;

    @Column(name = "academic_year", length = 20)
    private String academicYear;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;
}

package com.knownepal.education.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "entrance_exams")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EntranceExam extends Base {

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "name_nepali", length = 200)
    private String nameNepali;

    @Column(name = "slug", nullable = false, unique = true, length = 250)
    private String slug;

    @Column(name = "code", nullable = false, unique = true, length = 20)
    private String code;

    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_name", length = 200)
    private String boardName;

    @Enumerated(EnumType.STRING)
    @Column(name = "format", nullable = false, length = 20)
    private ExamFormat format;

    @Column(name = "exam_date", length = 50)
    private String examDate;

    @Column(name = "registration_deadline", length = 50)
    private String registrationDeadline;

    @Column(name = "eligibility", columnDefinition = "TEXT")
    private String eligibility;

    @Column(name = "syllabus", columnDefinition = "TEXT")
    private String syllabus;

    @Column(name = "fee_structure", length = 200)
    private String feeStructure;

    @Column(name = "total_seats")
    private Integer totalSeats;

    @Column(name = "duration_hours")
    private Integer durationHours;

    @Column(name = "total_marks")
    private Integer totalMarks;

    @Column(name = "pass_marks")
    private Integer passMarks;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "website", length = 255)
    private String website;

    @Column(name = "image_url", length = 255)
    private String imageUrl;
}

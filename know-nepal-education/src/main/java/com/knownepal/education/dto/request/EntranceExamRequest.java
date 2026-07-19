package com.knownepal.education.dto.request;

import com.knownepal.education.model.ExamFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class EntranceExamRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 200)
    @Schema(example = "MBBS Entrance Examination")
    private String name;

    @Size(max = 200)
    @Schema(example = "MBBS प्रवेश परीक्षा")
    private String nameNepali;

    @NotBlank(message = "Slug is required")
    @Size(max = 250)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid slug format")
    @Schema(example = "mbbs-entrance-examination")
    private String slug;

    @Size(max = 20)
    @Schema(example = "MBBS-ENT-001")
    private String code;

    @Schema(example = "1")
    private Long boardId;

    @Size(max = 200)
    @Schema(example = "Medical Education Commission")
    private String boardName;

    private ExamFormat format;

    @Size(max = 50)
    @Schema(example = "2082-04-20")
    private String examDate;

    @Size(max = 50)
    @Schema(example = "2082-03-25")
    private String registrationDeadline;

    @Size(max = 2000)
    @Schema(example = "Must have completed grade 12 with Biology, Chemistry, Physics")
    private String eligibility;

    @Size(max = 2000)
    @Schema(example = "Biology, Chemistry, Physics, and English")
    private String syllabus;

    @Size(max = 200)
    @Schema(example = "NPR 2000")
    private String feeStructure;

    @Schema(example = "500")
    private Integer totalSeats;

    @Schema(example = "3")
    private Integer durationHours;

    @Schema(example = "200")
    private Integer totalMarks;

    @Schema(example = "80")
    private Integer passMarks;

    @Size(max = 2000)
    @Schema(example = "National medical entrance examination for MBBS programs")
    private String description;

    @Schema(example = "https://mekc.gov.np")
    private String website;

    @Schema(example = "https://images.example.com/exam/mbbs.jpg")
    private String imageUrl;
}

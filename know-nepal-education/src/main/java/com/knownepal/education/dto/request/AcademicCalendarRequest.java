package com.knownepal.education.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AcademicCalendarRequest {

    @NotBlank(message = "Institution type is required")
    @Size(max = 30)
    @Schema(example = "UNIVERSITY")
    private String institutionType;

    @Schema(example = "1")
    private Long institutionId;

    @Size(max = 200)
    @Schema(example = "Tribhuvan University")
    private String institutionName;

    @NotBlank(message = "Event title is required")
    @Size(max = 200)
    @Schema(example = "Mid-term Examination")
    private String eventTitle;

    @Size(max = 2000)
    @Schema(example = "Mid-term examinations for all departments")
    private String eventDescription;

    @NotBlank(message = "Start date is required")
    @Size(max = 50)
    @Schema(example = "2082-05-01")
    private String startDate;

    @Size(max = 50)
    @Schema(example = "2082-05-15")
    private String endDate;

    @Size(max = 20)
    @Schema(example = "2082-83")
    private String academicYear;

    @Size(max = 50)
    @Schema(example = "Fall Semester")
    private String semester;

    @Schema(example = "https://images.example.com/calendar/midterm.jpg")
    private String imageUrl;
}

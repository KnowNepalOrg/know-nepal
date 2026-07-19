package com.knownepal.education.dto.request;

import com.knownepal.education.model.FeeComponent;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class FeeBreakdownRequest {

    @Schema(example = "1")
    private Long programId;

    @Size(max = 200)
    @Schema(example = "Bachelor of Computer Science")
    private String programName;

    @NotBlank(message = "Institution type is required")
    @Size(max = 30)
    @Schema(example = "UNIVERSITY")
    private String institutionType;

    @Schema(example = "1")
    private Long institutionId;

    @Size(max = 200)
    @Schema(example = "Tribhuvan University")
    private String institutionName;

    private FeeComponent component;

    @Schema(example = "50000.0")
    private Double amount;

    @Size(max = 10)
    @Schema(example = "NPR")
    private String currency;

    @Size(max = 50)
    @Schema(example = "Fall Semester")
    private String semester;

    @Size(max = 20)
    @Schema(example = "2082-83")
    private String academicYear;

    @Size(max = 2000)
    @Schema(example = "Tuition fee for first semester")
    private String description;
}

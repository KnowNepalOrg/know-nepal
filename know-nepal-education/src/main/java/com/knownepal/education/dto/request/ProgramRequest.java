package com.knownepal.education.dto.request;

import com.knownepal.education.model.InstitutionType;
import com.knownepal.education.model.ProgramLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ProgramRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 150)
    @Schema(example = "Bachelor of Business Administration")
    private String name;

    @Size(max = 150)
    @Schema(example = "व्यवस्थापन विज्ञानमा स्नातक")
    private String nameNepali;

    @NotBlank(message = "Slug is required")
    @Size(max = 180)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid slug format")
    @Schema(example = "bachelor-of-business-administration")
    private String slug;

    @Size(max = 20)
    @Schema(example = "BBA")
    private String code;

    private ProgramLevel level;

    @Size(max = 100)
    @Schema(example = "Business Administration")
    private String faculty;

    @Schema(example = "4")
    private Integer durationYears;

    @Schema(example = "64")
    private Integer totalSeats;

    @Size(max = 500)
    @Schema(example = "NPR 500,000 per year")
    private String feeStructure;

    @Size(max = 500)
    @Schema(example = "Plus 2 or equivalent with minimum GPA 2.0")
    private String eligibility;

    @Size(max = 2000)
    @Schema(example = "Comprehensive business program covering management, finance, and marketing")
    private String description;

    private InstitutionType institutionType;

    @Schema(example = "1")
    private Long institutionId;

    @Size(max = 150)
    @Schema(example = "Kathmandu University School of Management")
    private String institutionName;

    @Schema(example = "https://images.example.com/program/bba.jpg")
    private String imageUrl;
}

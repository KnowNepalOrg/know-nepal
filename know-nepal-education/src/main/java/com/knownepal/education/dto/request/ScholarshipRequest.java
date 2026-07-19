package com.knownepal.education.dto.request;

import com.knownepal.education.model.ScholarshipType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ScholarshipRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 200)
    @Schema(example = "Nepal Government Scholarship")
    private String name;

    @Size(max = 200)
    @Schema(example = "नेपाल सरकार छात्रवृत्ति")
    private String nameNepali;

    @NotBlank(message = "Slug is required")
    @Size(max = 250)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid slug format")
    @Schema(example = "nepal-government-scholarship")
    private String slug;

    private ScholarshipType type;

    @Size(max = 200)
    @Schema(example = "Ministry of Education")
    private String provider;

    @Size(max = 200)
    @Schema(example = "Full tuition fee coverage")
    private String amount;

    @Size(max = 2000)
    @Schema(example = "Must be Nepali citizen with minimum GPA 3.5")
    private String eligibility;

    @Size(max = 50)
    @Schema(example = "2082-03-15")
    private String deadline;

    @Schema(example = "https://scholarship.gov.np/apply")
    private String applicationUrl;

    @Size(max = 2000)
    @Schema(example = "Merit-based scholarship for undergraduate students")
    private String description;

    @Schema(example = "100")
    private Integer totalSlots;

    @Schema(example = "true")
    private Boolean isRenewable;

    @Schema(example = "3")
    private Long provinceId;

    @Size(max = 100)
    @Schema(example = "Bagmati")
    private String provinceName;

    @Schema(example = "27")
    private Long districtId;

    @Size(max = 100)
    @Schema(example = "Kathmandu")
    private String districtName;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]{7,15}$", message = "Invalid phone format")
    @Schema(example = "+977-1-4244444")
    private String contactPhone;

    @Email(message = "Invalid email format")
    @Schema(example = "scholarship@moe.gov.np")
    private String contactEmail;

    @Schema(example = "https://images.example.com/scholarship/gov.jpg")
    private String imageUrl;
}

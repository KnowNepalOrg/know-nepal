package com.knownepal.education.dto.request;

import com.knownepal.education.model.BoardCategory;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ExamBoardRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 200)
    @Schema(example = "National Examination Board")
    private String name;

    @Size(max = 200)
    @Schema(example = "राष्ट्रिय परीक्षा बोर्ड")
    private String nameNepali;

    @NotBlank(message = "Slug is required")
    @Size(max = 250)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid slug format")
    @Schema(example = "national-examination-board")
    private String slug;

    @Size(max = 20)
    @Schema(example = "NEB-001")
    private String code;

    private BoardCategory category;

    @Schema(example = "1971")
    private Integer establishedYear;

    @Size(max = 200)
    @Schema(example = "Sanothimi, Bhaktapur")
    private String headquarters;

    @Schema(example = "https://neb.gov.np")
    private String website;

    @Size(max = 2000)
    @Schema(example = "National examination board of Nepal")
    private String description;

    @Size(max = 2000)
    @Schema(example = "GPA system with 4.0 scale")
    private String gradingSystem;

    @Schema(example = "3")
    private Long provinceId;

    @Size(max = 100)
    @Schema(example = "Bagmati")
    private String provinceName;

    @Schema(example = "27")
    private Long districtId;

    @Size(max = 100)
    @Schema(example = "Bhaktapur")
    private String districtName;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]{7,15}$", message = "Invalid phone format")
    @Schema(example = "+977-1-6631234")
    private String phone;

    @Email(message = "Invalid email format")
    @Schema(example = "info@neb.gov.np")
    private String email;

    @Schema(example = "https://images.example.com/board/neb.jpg")
    private String imageUrl;
}

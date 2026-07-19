package com.knownepal.education.dto.request;

import com.knownepal.education.model.QualificationLevel;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class TeacherProfileRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 200)
    @Schema(example = "Dr. Ram Prasad Sharma")
    private String name;

    @Size(max = 200)
    @Schema(example = "डा. राम प्रसाद शर्मा")
    private String nameNepali;

    @NotBlank(message = "Slug is required")
    @Size(max = 250)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid slug format")
    @Schema(example = "dr-ram-prasad-sharma")
    private String slug;

    private QualificationLevel qualificationLevel;

    @Size(max = 200)
    @Schema(example = "PhD in Computer Science from Tribhuvan University")
    private String qualificationDetail;

    @Size(max = 200)
    @Schema(example = "Artificial Intelligence and Machine Learning")
    private String specialization;

    @Schema(example = "15")
    private Integer experienceYears;

    @Size(max = 30)
    @Schema(example = "UNIVERSITY")
    private String institutionType;

    @Schema(example = "1")
    private Long institutionId;

    @Size(max = 200)
    @Schema(example = "Tribhuvan University")
    private String institutionName;

    @Size(max = 200)
    @Schema(example = "Computer Science and Engineering")
    private String department;

    @Size(max = 100)
    @Schema(example = "Associate Professor")
    private String designation;

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
    @Schema(example = "+977-9841234567")
    private String phone;

    @Email(message = "Invalid email format")
    @Schema(example = "ram.sharma@tu.edu.np")
    private String email;

    @Size(max = 2000)
    @Schema(example = "Experienced educator specializing in AI and machine learning research")
    private String bio;

    @Schema(example = "https://images.example.com/teacher/ram.jpg")
    private String imageUrl;
}

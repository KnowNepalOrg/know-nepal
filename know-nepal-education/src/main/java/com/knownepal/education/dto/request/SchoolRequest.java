package com.knownepal.education.dto.request;

import com.knownepal.education.model.EducationLevel;
import com.knownepal.education.model.SchoolType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class SchoolRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 150)
    @Schema(example = "Budhanilkantha School")
    private String name;

    @Size(max = 150)
    @Schema(example = "बुढानिलकण्ठ विद्यालय")
    private String nameNepali;

    @NotBlank(message = "Slug is required")
    @Size(max = 180)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid slug format")
    @Schema(example = "budhanilkantha-school")
    private String slug;

    @Size(max = 20)
    @Schema(example = "SCH-KTM-001")
    private String code;

    private SchoolType type;
    private EducationLevel level;

    @Schema(example = "1985")
    private Integer establishedYear;

    @Size(max = 100)
    @Schema(example = "NEB / Cambridge")
    private String affiliation;

    @Schema(example = "2500")
    private Integer studentCount;

    @Schema(example = "120")
    private Integer teacherCount;

    @Schema(example = "5.5")
    private Double areaSqKm;

    @Size(max = 2000)
    @Schema(example = "Premier boarding school in Kathmandu")
    private String description;

    private Double latitude;
    private Double longitude;
    private Double elevation;

    @Schema(example = "1")
    private Long provinceId;

    @Size(max = 100)
    @Schema(example = "Bagmati")
    private String provinceName;

    @Schema(example = "27")
    private Long districtId;

    @Size(max = 100)
    @Schema(example = "Kathmandu")
    private String districtName;

    @Schema(example = "27001")
    private Long municipalityId;

    @Size(max = 150)
    @Schema(example = "Kathmandu Metropolitan City")
    private String municipalityName;

    @Schema(example = "2700101")
    private Long wardId;

    @Size(max = 50)
    @Schema(example = "Ward 1")
    private String wardName;

    @Size(max = 300)
    @Schema(example = "Balaju, Kathmandu 44600")
    private String address;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]{7,15}$", message = "Invalid phone format")
    @Schema(example = "+977-1-4355555")
    private String phone;

    @Email(message = "Invalid email format")
    @Schema(example = "info@budhanilkantha.edu.np")
    private String email;

    @Schema(example = "https://budhanilkantha.edu.np")
    private String website;

    @Schema(example = "https://images.example.com/school/budhanilkantha.jpg")
    private String imageUrl;
}

package com.knownepal.education.dto.request;

import com.knownepal.education.model.CollegeLevel;
import com.knownepal.education.model.CollegeType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CollegeRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 150)
    @Schema(example = "Kathmandu University School of Management")
    private String name;

    @Size(max = 150)
    @Schema(example = "काठमाडौं विश्वविद्यालय व्यवस्थापन विद्यालय")
    private String nameNepali;

    @NotBlank(message = "Slug is required")
    @Size(max = 180)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid slug format")
    @Schema(example = "kathmandu-university-school-of-management")
    private String slug;

    @Size(max = 20)
    @Schema(example = "COL-KTU-001")
    private String code;

    private CollegeType type;
    private CollegeLevel level;

    @Schema(example = "1993")
    private Integer establishedYear;

    @Size(max = 100)
    @Schema(example = "Kathmandu University")
    private String affiliation;

    @Schema(example = "800")
    private Integer studentCount;

    @Schema(example = "45")
    private Integer teacherCount;

    @Size(max = 500)
    @Schema(example = "Library, Sports, Computer Lab")
    private String facilities;

    @Size(max = 2000)
    @Schema(example = "Leading management college affiliated to KU")
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
    @Schema(example = "Hattiban, Lalitpur 44700")
    private String address;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]{7,15}$", message = "Invalid phone format")
    @Schema(example = "+977-1-5185760")
    private String phone;

    @Email(message = "Invalid email format")
    @Schema(example = "info@kusom.edu.np")
    private String email;

    @Schema(example = "https://kusom.edu.np")
    private String website;

    @Schema(example = "https://images.example.com/college/kusom.jpg")
    private String imageUrl;
}

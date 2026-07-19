package com.knownepal.education.dto.request;

import com.knownepal.education.model.UniversityType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UniversityRequest {

    @NotBlank(message = "Name is required")
    @Size(max = 150)
    @Schema(example = "Tribhuvan University")
    private String name;

    @Size(max = 150)
    @Schema(example = "त्रिभुवन विश्वविद्यालय")
    private String nameNepali;

    @NotBlank(message = "Slug is required")
    @Size(max = 180)
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Invalid slug format")
    @Schema(example = "tribhuvan-university")
    private String slug;

    @Size(max = 20)
    @Schema(example = "TU")
    private String code;

    private UniversityType type;

    @Schema(example = "1959")
    private Integer establishedYear;

    @Size(max = 100)
    @Schema(example = "Prof. Dr. Surendra Raj Gautam")
    private String viceChancellor;

    @Schema(example = "250000")
    private Integer studentCount;

    @Schema(example = "4500")
    private Integer facultyCount;

    @Schema(example = "12")
    private Integer campusCount;

    @Schema(example = "632")
    private Integer affiliatedColleges;

    @Size(max = 2000)
    @Schema(example = "Management, Science, Humanities, Education, Law, Engineering")
    private String faculties;

    @Size(max = 2000)
    @Schema(example = "Largest and oldest university in Nepal")
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
    @Schema(example = "Kirtipur, Kathmandu 44618")
    private String address;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]{7,15}$", message = "Invalid phone format")
    @Schema(example = "+977-1-4330466")
    private String phone;

    @Email(message = "Invalid email format")
    @Schema(example = "info@tu.edu.np")
    private String email;

    @Schema(example = "https://tu.edu.np")
    private String website;

    @Schema(example = "https://images.example.com/university/tu.jpg")
    private String imageUrl;
}

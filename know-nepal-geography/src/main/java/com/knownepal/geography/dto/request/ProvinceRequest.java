package com.knownepal.geography.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for creating or updating a province")
public class ProvinceRequest {

    @NotBlank(message = "Province name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Schema(description = "English name of the province", example = "Koshi", maxLength = 100)
    private String name;

    @Size(max = 100, message = "Nepali name must not exceed 100 characters")
    @Schema(description = "Nepali name of the province", example = "कोशी", maxLength = 100)
    private String nameNepali;

    @NotBlank(message = "Province code is required")
    @Size(max = 10, message = "Code must not exceed 10 characters")
    @Schema(description = "Unique administrative code", example = "1", maxLength = 10)
    private String code;

    @Positive(message = "Area must be positive")
    @Schema(description = "Total area in square kilometers", example = "25905.71")
    private Double area;

    @Positive(message = "Population must be positive")
    @Schema(description = "Total population", example = "4972048")
    private Long population;

    @Size(max = 100, message = "Capital must not exceed 100 characters")
    @Schema(description = "Capital city of the province", example = "Biratnagar", maxLength = 100)
    private String capital;

    @Positive(message = "Number of districts must be positive")
    @Schema(description = "Number of districts in the province", example = "14")
    private Integer numberOfDistricts;

    @NotBlank(message = "Slug is required")
    @Size(max = 150, message = "Slug must not exceed 150 characters")
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug must be lowercase alphanumeric with hyphens")
    @Schema(description = "URL-friendly unique identifier", example = "koshi", maxLength = 150)
    private String slug;

    @Schema(description = "Latitude coordinate", example = "27.0")
    private Double latitude;

    @Schema(description = "Longitude coordinate", example = "87.3")
    private Double longitude;

    @Schema(description = "Description of the province", example = "Koshi Province is the easternmost province of Nepal.")
    private String description;

    @Size(max = 255, message = "Website URL must not exceed 255 characters")
    @Schema(description = "Official website URL", example = "https://koshi.gov.np", maxLength = 255)
    private String websiteUrl;

    @Size(max = 50, message = "Contact phone must not exceed 50 characters")
    @Schema(description = "Contact phone number", example = "+977-21-123456", maxLength = 50)
    private String contactPhone;

    @Size(max = 100, message = "Contact email must not exceed 100 characters")
    @Email(message = "Contact email must be valid")
    @Schema(description = "Contact email address", example = "info@koshi.gov.np", maxLength = 100)
    private String contactEmail;

    @Size(max = 255, message = "Image URL must not exceed 255 characters")
    @Schema(description = "Image URL for the province", example = "https://example.com/koshi.jpg", maxLength = 255)
    private String imageUrl;
}

package com.knownepal.geography.dto.request;

import com.knownepal.geography.model.MunicipalityType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for creating or updating a municipality")
public class MunicipalityRequest {

    @NotBlank(message = "Municipality name is required")
    @Size(max = 150, message = "Name must not exceed 150 characters")
    @Schema(description = "English name of the municipality", example = "Kathmandu", maxLength = 150)
    private String name;

    @Size(max = 150, message = "Nepali name must not exceed 150 characters")
    @Schema(description = "Nepali name of the municipality", example = "काठमाडौँ", maxLength = 150)
    private String nameNepali;

    @NotBlank(message = "Municipality code is required")
    @Size(max = 10, message = "Code must not exceed 10 characters")
    @Schema(description = "Unique administrative code", example = "KTM01", maxLength = 10)
    private String code;

    @NotNull(message = "Municipality type is required")
    @Schema(description = "Type of municipality", example = "METROPOLITAN_CITY")
    private MunicipalityType type;

    @Positive(message = "Area must be positive")
    @Schema(description = "Total area in square kilometers", example = "49.45")
    private Double area;

    @Positive(message = "Population must be positive")
    @Schema(description = "Total population", example = "1442271")
    private Long population;

    @Positive(message = "Ward count must be positive")
    @Schema(description = "Number of wards", example = "32")
    private Integer wardCount;

    @NotNull(message = "District ID is required")
    @Positive(message = "District ID must be positive")
    @Schema(description = "ID of the district this municipality belongs to", example = "26")
    private Long districtId;

    @NotBlank(message = "Slug is required")
    @Size(max = 150, message = "Slug must not exceed 150 characters")
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug must be lowercase alphanumeric with hyphens")
    @Schema(description = "URL-friendly unique identifier", example = "kathmandu-kathmandu", maxLength = 150)
    private String slug;

    @Schema(description = "Latitude coordinate", example = "27.72")
    private Double latitude;

    @Schema(description = "Longitude coordinate", example = "85.32")
    private Double longitude;

    @Schema(description = "Elevation in meters", example = "1400")
    private Double elevation;

    @Schema(description = "Description of the municipality")
    private String description;

    @Size(max = 255, message = "Website URL must not exceed 255 characters")
    @Schema(description = "Official website URL", maxLength = 255)
    private String websiteUrl;

    @Size(max = 50, message = "Contact phone must not exceed 50 characters")
    @Schema(description = "Contact phone number", maxLength = 50)
    private String contactPhone;

    @Size(max = 100, message = "Contact email must not exceed 100 characters")
    @Email(message = "Contact email must be valid")
    @Schema(description = "Contact email address", maxLength = 100)
    private String contactEmail;

    @Size(max = 255, message = "Image URL must not exceed 255 characters")
    @Schema(description = "Image URL for the municipality", maxLength = 255)
    private String imageUrl;
}

package com.knownepal.geography.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for creating or updating a ward")
public class WardRequest {

    @NotBlank(message = "Ward name is required")
    @Size(max = 200, message = "Name must not exceed 200 characters")
    @Schema(description = "English name of the ward", example = "Ward No. 1", maxLength = 200)
    private String name;

    @Size(max = 200, message = "Nepali name must not exceed 200 characters")
    @Schema(description = "Nepali name of the ward", example = "वड नं. १", maxLength = 200)
    private String nameNepali;

    @NotNull(message = "Ward number is required")
    @Positive(message = "Ward number must be positive")
    @Schema(description = "Ward number within the municipality", example = "1")
    private Integer number;

    @NotNull(message = "Municipality ID is required")
    @Positive(message = "Municipality ID must be positive")
    @Schema(description = "ID of the municipality this ward belongs to", example = "299")
    private Long municipalityId;

    @Schema(description = "Latitude coordinate", example = "27.712")
    private Double latitude;

    @Schema(description = "Longitude coordinate", example = "85.312")
    private Double longitude;

    @Schema(description = "Elevation in meters", example = "1400")
    private Double elevation;

    @Positive(message = "Area must be positive")
    @Schema(description = "Total area in square kilometers", example = "1.20")
    private Double area;

    @Positive(message = "Population must be positive")
    @Schema(description = "Total population", example = "24500")
    private Long population;

    @Schema(description = "Description of the ward")
    private String description;

    @NotBlank(message = "Slug is required")
    @Size(max = 200, message = "Slug must not exceed 200 characters")
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug must be lowercase alphanumeric with hyphens")
    @Schema(description = "URL-friendly unique identifier", example = "kathmet-ward-1", maxLength = 200)
    private String slug;

    @Size(max = 50, message = "Contact phone must not exceed 50 characters")
    @Schema(description = "Contact phone number", maxLength = 50)
    private String contactPhone;

    @Size(max = 100, message = "Contact email must not exceed 100 characters")
    @Email(message = "Contact email must be valid")
    @Schema(description = "Contact email address", maxLength = 100)
    private String contactEmail;

    @Size(max = 255, message = "Image URL must not exceed 255 characters")
    @Schema(description = "Image URL for the ward", maxLength = 255)
    private String imageUrl;
}

package com.knownepal.geography.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for creating or updating a district")
public class DistrictRequest {

    @NotBlank(message = "District name is required")
    @Size(max = 100, message = "Name must not exceed 100 characters")
    @Schema(description = "English name of the district", example = "Kathmandu", maxLength = 100)
    private String name;

    @Size(max = 100, message = "Nepali name must not exceed 100 characters")
    @Schema(description = "Nepali name of the district", example = "काठमाडौँ", maxLength = 100)
    private String nameNepali;

    @NotBlank(message = "District code is required")
    @Size(max = 10, message = "Code must not exceed 10 characters")
    @Schema(description = "Unique administrative code", example = "KTM", maxLength = 10)
    private String code;

    @Positive(message = "Area must be positive")
    @Schema(description = "Total area in square kilometers", example = "395.0")
    private Double area;

    @Positive(message = "Population must be positive")
    @Schema(description = "Total population", example = "1442271")
    private Long population;

    @Size(max = 100, message = "Headquarters must not exceed 100 characters")
    @Schema(description = "Headquarters city", example = "Kathmandu", maxLength = 100)
    private String headquarters;

    @NotNull(message = "Province ID is required")
    @Positive(message = "Province ID must be positive")
    @Schema(description = "ID of the province this district belongs to", example = "3")
    private Long provinceId;

    @NotBlank(message = "Slug is required")
    @Size(max = 150, message = "Slug must not exceed 150 characters")
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug must be lowercase alphanumeric with hyphens")
    @Schema(description = "URL-friendly unique identifier", example = "kathmandu", maxLength = 150)
    private String slug;

    @Schema(description = "Latitude coordinate", example = "27.72")
    private Double latitude;

    @Schema(description = "Longitude coordinate", example = "85.32")
    private Double longitude;

    @Schema(description = "Description of the district", example = "Kathmandu District is the capital district of Nepal.")
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
    @Schema(description = "Image URL for the district", maxLength = 255)
    private String imageUrl;
}

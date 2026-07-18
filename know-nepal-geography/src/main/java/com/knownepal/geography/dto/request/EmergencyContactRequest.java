package com.knownepal.geography.dto.request;

import com.knownepal.geography.model.EmergencyContactType;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(description = "Request body for creating or updating an emergency contact")
public class EmergencyContactRequest {

    @NotBlank(message = "Contact name is required")
    @Size(max = 200, message = "Name must not exceed 200 characters")
    @Schema(description = "English name of the emergency contact", example = "Nepal Police", maxLength = 200)
    private String name;

    @Size(max = 200, message = "Nepali name must not exceed 200 characters")
    @Schema(description = "Nepali name of the emergency contact", example = "नेपाल प्रहरी", maxLength = 200)
    private String nameNepali;

    @NotNull(message = "Contact type is required")
    @Schema(description = "Type of emergency contact", example = "POLICE")
    private EmergencyContactType type;

    @NotBlank(message = "Phone number is required")
    @Size(max = 50, message = "Phone must not exceed 50 characters")
    @Schema(description = "Primary phone number", example = "100", maxLength = 50)
    private String phone;

    @Size(max = 50, message = "Alternate phone must not exceed 50 characters")
    @Schema(description = "Alternate phone number", maxLength = 50)
    private String alternatePhone;

    @Size(max = 100, message = "Email must not exceed 100 characters")
    @Email(message = "Email must be valid")
    @Schema(description = "Email address", maxLength = 100)
    private String email;

    @Size(max = 255, message = "Website must not exceed 255 characters")
    @Schema(description = "Website URL", maxLength = 255)
    private String website;

    @Size(max = 500, message = "Address must not exceed 500 characters")
    @Schema(description = "Physical address", maxLength = 500)
    private String address;

    @Schema(description = "Description of the emergency contact")
    private String description;

    @Schema(description = "Whether this is a nationwide number", example = "true")
    private Boolean isNational;

    @Positive(message = "District ID must be positive")
    @Schema(description = "ID of the district (null for national contacts)")
    private Long districtId;

    @Positive(message = "Province ID must be positive")
    @Schema(description = "ID of the province (null for national contacts)")
    private Long provinceId;

    @Schema(description = "Latitude coordinate", example = "27.72")
    private Double latitude;

    @Schema(description = "Longitude coordinate", example = "85.32")
    private Double longitude;

    @NotBlank(message = "Slug is required")
    @Size(max = 200, message = "Slug must not exceed 200 characters")
    @Pattern(regexp = "^[a-z0-9]+(?:-[a-z0-9]+)*$", message = "Slug must be lowercase alphanumeric with hyphens")
    @Schema(description = "URL-friendly unique identifier", example = "nepal-police", maxLength = 200)
    private String slug;

    @Size(max = 200, message = "Contact person must not exceed 200 characters")
    @Schema(description = "Contact person name", maxLength = 200)
    private String contactPerson;

    @Size(max = 200, message = "Available hours must not exceed 200 characters")
    @Schema(description = "Available hours", example = "24/7", maxLength = 200)
    private String availableHours;

    @Size(max = 255, message = "Image URL must not exceed 255 characters")
    @Schema(description = "Image URL", maxLength = 255)
    private String imageUrl;
}

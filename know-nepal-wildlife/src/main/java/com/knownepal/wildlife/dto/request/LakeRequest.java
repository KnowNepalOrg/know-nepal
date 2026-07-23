package com.knownepal.wildlife.dto.request;

import com.knownepal.wildlife.model.LakeType;
import com.knownepal.wildlife.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LakeRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Lake type is required")
    @ValidEnum(enumClass = LakeType.class)
    private String lakeType;

    private String district;

    private String province;

    private String municipality;

    private Double latitude;

    private Double longitude;

    private Integer elevationM;

    private Double areaSqKm;

    private Integer maxDepthM;

    private Double lengthKm;

    private Double widthKm;

    private String howToReach;

    private String bestSeason;

    private Integer entryFeeNpr;

    private String contactInfo;

    private String imageUrl;

    private String photos;

    private String notableFeatures;

    private Boolean isFeatured;
}

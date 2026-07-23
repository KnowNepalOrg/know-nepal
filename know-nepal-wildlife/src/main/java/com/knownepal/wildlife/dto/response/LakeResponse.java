package com.knownepal.wildlife.dto.response;

import lombok.Data;

@Data
public class LakeResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
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

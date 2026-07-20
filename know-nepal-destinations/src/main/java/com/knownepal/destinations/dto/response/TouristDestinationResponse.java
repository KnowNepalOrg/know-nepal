package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.BestSeason;
import com.knownepal.destinations.model.DestinationType;
import com.knownepal.destinations.model.DifficultyLevel;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TouristDestinationResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private DestinationType destinationType;
    private Long categoryId;
    private String categoryName;
    private Long provinceId;
    private String provinceName;
    private Long districtId;
    private String districtName;
    private Long municipalityId;
    private String municipalityName;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private Integer altitudeMeters;
    private DifficultyLevel difficultyLevel;
    private BestSeason bestSeason;
    private BigDecimal entryFeeNpr;
    private String visitDuration;
    private Boolean isPopular;
    private Boolean isFeatured;
    private List<TagResponse> tags;
    private Double averageRating;
    private Integer reviewCount;
}

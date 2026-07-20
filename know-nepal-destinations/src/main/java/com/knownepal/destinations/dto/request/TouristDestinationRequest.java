package com.knownepal.destinations.dto.request;

import com.knownepal.destinations.model.BestSeason;
import com.knownepal.destinations.model.DestinationType;
import com.knownepal.destinations.model.DifficultyLevel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class TouristDestinationRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotNull(message = "Destination type is required")
    private DestinationType destinationType;

    private Long categoryId;

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
    private List<Long> tagIds;
}

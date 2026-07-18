package com.knownepal.geography.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class WardResponse {

    private Long id;
    private String name;
    private String nameNepali;
    private Integer number;
    private String slug;
    private Double latitude;
    private Double longitude;
    private Double elevation;
    private Double area;
    private Long population;
    private String description;
    private String contactPhone;
    private String contactEmail;
    private String imageUrl;
    private Long municipalityId;
    private String municipalityName;
    private Long districtId;
    private String districtName;
    private Long provinceId;
    private String provinceName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

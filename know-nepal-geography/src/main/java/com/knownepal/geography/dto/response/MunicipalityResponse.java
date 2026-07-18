package com.knownepal.geography.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.knownepal.geography.model.MunicipalityType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MunicipalityResponse {

    private Long id;
    private String name;
    private String nameNepali;
    private String code;
    private String slug;
    private MunicipalityType type;
    private Double area;
    private Long population;
    private Integer wardCount;
    private Double latitude;
    private Double longitude;
    private Double elevation;
    private String description;
    private String websiteUrl;
    private String contactPhone;
    private String contactEmail;
    private String imageUrl;
    private Long districtId;
    private String districtName;
    private Long provinceId;
    private String provinceName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

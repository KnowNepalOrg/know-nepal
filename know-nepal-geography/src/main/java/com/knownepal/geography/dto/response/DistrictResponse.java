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
public class DistrictResponse {

    private Long id;
    private String name;
    private String nameNepali;
    private String code;
    private String slug;
    private Double area;
    private Long population;
    private String headquarters;
    private Double latitude;
    private Double longitude;
    private String description;
    private String websiteUrl;
    private String contactPhone;
    private String contactEmail;
    private String imageUrl;
    private Long provinceId;
    private String provinceName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

package com.knownepal.geography.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.knownepal.geography.model.EmergencyContactType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EmergencyContactResponse {

    private Long id;
    private String name;
    private String nameNepali;
    private EmergencyContactType type;
    private String phone;
    private String alternatePhone;
    private String email;
    private String website;
    private String address;
    private String description;
    private Boolean isNational;
    private Double latitude;
    private Double longitude;
    private String slug;
    private String contactPerson;
    private String availableHours;
    private String imageUrl;
    private Long districtId;
    private String districtName;
    private Long provinceId;
    private String provinceName;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}

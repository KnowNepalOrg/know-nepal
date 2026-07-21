package com.knownepal.culture.dto.request;

import com.knownepal.culture.model.RegionType;
import com.knownepal.culture.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class EthnicGroupRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    private Long populationEstimate;

    private Long languageId;

    @ValidEnum(enumClass = RegionType.class, message = "must be a valid region type")
    private String regionType;

    private String province;

    private String subRegion;

    private String traditionalOccupation;

    private String socialStructure;

    private String religion;

    private String customs;

    private String rituals;

    private String festivals;

    private Boolean isIndigenous;

    private Boolean isDeprived;

    private String origin;

    private String migrationHistory;
}

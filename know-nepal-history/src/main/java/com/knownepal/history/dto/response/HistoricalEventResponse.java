package com.knownepal.history.dto.response;

import lombok.Data;

@Data
public class HistoricalEventResponse {

    private Long id;
    private String slug;
    private String name;
    private String description;
    private String eventType;
    private Long eraId;
    private String eraName;
    private Long dynastyId;
    private String dynastyName;
    private Integer eventYear;
    private Integer endYear;
    private String location;
    private String significance;
    private String keyFiguresInvolved;
    private String outcome;
    private Boolean isFeatured;
}

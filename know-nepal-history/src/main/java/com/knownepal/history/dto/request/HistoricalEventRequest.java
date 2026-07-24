package com.knownepal.history.dto.request;

import com.knownepal.history.model.EventType;
import com.knownepal.history.validator.ValidEnum;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HistoricalEventRequest {

    @NotBlank(message = "Name is required")
    private String name;

    private String description;

    @NotBlank(message = "Event type is required")
    @ValidEnum(enumClass = EventType.class, message = "must be a valid event type")
    private String eventType;

    @NotBlank(message = "Era ID is required")
    private Long eraId;

    private Long dynastyId;

    @NotBlank(message = "Event year is required")
    private Integer eventYear;

    private Integer endYear;

    private String location;

    private String significance;

    private String keyFiguresInvolved;

    private String outcome;

    private Boolean isFeatured;
}

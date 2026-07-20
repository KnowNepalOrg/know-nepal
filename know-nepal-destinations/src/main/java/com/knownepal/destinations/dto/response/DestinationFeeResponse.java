package com.knownepal.destinations.dto.response;

import com.knownepal.destinations.model.FeeType;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DestinationFeeResponse {

    private Long id;
    private Long destinationId;
    private FeeType feeType;
    private BigDecimal amount;
    private String currency;
    private String description;
    private Boolean isMandatory;
}

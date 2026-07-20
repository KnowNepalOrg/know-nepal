package com.knownepal.destinations.dto.request;

import com.knownepal.destinations.model.FeeType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class DestinationFeeRequest {

    @NotNull(message = "Fee type is required")
    private FeeType feeType;

    @NotNull(message = "Amount is required")
    private BigDecimal amount;

    private String currency;
    private String description;
    private Boolean isMandatory;
}

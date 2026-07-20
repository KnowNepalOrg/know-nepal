package com.knownepal.destinations.mapper;

import com.knownepal.destinations.dto.response.DestinationFeeResponse;
import com.knownepal.destinations.model.DestinationFee;

public class DestinationFeeMapper {

    private DestinationFeeMapper() {
    }

    public static DestinationFeeResponse toResponse(DestinationFee entity) {
        DestinationFeeResponse response = new DestinationFeeResponse();
        response.setId(entity.getId());
        response.setFeeType(entity.getFeeType());
        response.setAmount(entity.getAmount());
        response.setCurrency(entity.getCurrency());
        response.setDescription(entity.getDescription());
        response.setIsMandatory(entity.getIsMandatory());
        if (entity.getDestination() != null) {
            response.setDestinationId(entity.getDestination().getId());
        }
        return response;
    }
}

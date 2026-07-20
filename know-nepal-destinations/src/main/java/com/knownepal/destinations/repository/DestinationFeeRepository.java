package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationFee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationFeeRepository extends JpaRepository<DestinationFee, Long> {

    List<DestinationFee> findByDestinationId(Long destinationId);
}

package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.NearbyDestination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NearbyDestinationRepository extends JpaRepository<NearbyDestination, Long> {

    List<NearbyDestination> findByDestinationId(Long destinationId);
}

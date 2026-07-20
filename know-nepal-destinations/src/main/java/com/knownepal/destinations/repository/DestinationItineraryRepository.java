package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationItinerary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface DestinationItineraryRepository extends JpaRepository<DestinationItinerary, Long>,
        JpaSpecificationExecutor<DestinationItinerary> {

    Optional<DestinationItinerary> findBySlug(String slug);

    boolean existsBySlug(String slug);
}

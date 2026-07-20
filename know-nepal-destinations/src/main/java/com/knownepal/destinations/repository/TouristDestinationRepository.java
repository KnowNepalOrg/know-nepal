package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.TouristDestination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TouristDestinationRepository extends JpaRepository<TouristDestination, Long>,
        JpaSpecificationExecutor<TouristDestination> {

    Optional<TouristDestination> findBySlug(String slug);

    boolean existsBySlug(String slug);
}

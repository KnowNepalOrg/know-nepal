package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DestinationCategoryRepository extends JpaRepository<DestinationCategory, Long> {

    Optional<DestinationCategory> findBySlug(String slug);

    boolean existsBySlug(String slug);

    boolean existsByName(String name);
}

package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationTag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DestinationTagRepository extends JpaRepository<DestinationTag, Long> {

    Optional<DestinationTag> findBySlug(String slug);

    boolean existsBySlug(String slug);
}

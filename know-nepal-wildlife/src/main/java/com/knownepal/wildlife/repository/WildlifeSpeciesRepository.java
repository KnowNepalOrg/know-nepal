package com.knownepal.wildlife.repository;

import com.knownepal.wildlife.model.WildlifeSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface WildlifeSpeciesRepository extends JpaRepository<WildlifeSpecies, Long>, JpaSpecificationExecutor<WildlifeSpecies> {

    Optional<WildlifeSpecies> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<WildlifeSpecies> findByNameContainingIgnoreCase(String name);
}

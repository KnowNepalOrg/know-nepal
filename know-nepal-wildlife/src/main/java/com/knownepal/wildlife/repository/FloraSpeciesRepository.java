package com.knownepal.wildlife.repository;

import com.knownepal.wildlife.model.FloraSpecies;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface FloraSpeciesRepository extends JpaRepository<FloraSpecies, Long>, JpaSpecificationExecutor<FloraSpecies> {

    Optional<FloraSpecies> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<FloraSpecies> findByNameContainingIgnoreCase(String name);
}

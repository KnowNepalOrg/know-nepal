package com.knownepal.history.repository;

import com.knownepal.history.model.HistoricalEra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface HistoricalEraRepository extends JpaRepository<HistoricalEra, Long>, JpaSpecificationExecutor<HistoricalEra> {

    Optional<HistoricalEra> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<HistoricalEra> findByNameContainingIgnoreCase(String name);
}

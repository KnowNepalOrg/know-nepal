package com.knownepal.history.repository;

import com.knownepal.history.model.HistoricalFigure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface HistoricalFigureRepository extends JpaRepository<HistoricalFigure, Long>, JpaSpecificationExecutor<HistoricalFigure> {

    Optional<HistoricalFigure> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<HistoricalFigure> findByNameContainingIgnoreCase(String name);
}

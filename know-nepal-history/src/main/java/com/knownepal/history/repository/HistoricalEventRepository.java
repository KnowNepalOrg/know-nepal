package com.knownepal.history.repository;

import com.knownepal.history.model.HistoricalEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface HistoricalEventRepository extends JpaRepository<HistoricalEvent, Long>, JpaSpecificationExecutor<HistoricalEvent> {

    Optional<HistoricalEvent> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<HistoricalEvent> findByNameContainingIgnoreCase(String name);
}

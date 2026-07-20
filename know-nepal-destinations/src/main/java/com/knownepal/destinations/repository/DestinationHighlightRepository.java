package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationHighlight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationHighlightRepository extends JpaRepository<DestinationHighlight, Long> {

    List<DestinationHighlight> findByDestinationIdOrderByDisplayOrderAsc(Long destinationId);
}

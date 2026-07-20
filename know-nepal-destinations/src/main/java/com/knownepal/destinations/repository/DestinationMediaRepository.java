package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationMedia;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationMediaRepository extends JpaRepository<DestinationMedia, Long> {

    List<DestinationMedia> findByDestinationIdOrderByDisplayOrderAsc(Long destinationId);
}

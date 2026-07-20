package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationTagMapping;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationTagMappingRepository extends JpaRepository<DestinationTagMapping, Long> {

    List<DestinationTagMapping> findByDestinationId(Long destinationId);

    List<DestinationTagMapping> findByTagId(Long tagId);

    void deleteByDestinationIdAndTagId(Long destinationId, Long tagId);
}

package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.RouteDestination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteDestinationRepository extends JpaRepository<RouteDestination, Long> {

    List<RouteDestination> findByRouteIdOrderBySequenceOrderAsc(Long routeId);

    List<RouteDestination> findByDestinationId(Long destinationId);
}

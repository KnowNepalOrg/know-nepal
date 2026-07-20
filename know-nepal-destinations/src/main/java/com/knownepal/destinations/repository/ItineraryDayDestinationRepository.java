package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.ItineraryDayDestination;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItineraryDayDestinationRepository extends JpaRepository<ItineraryDayDestination, Long> {

    List<ItineraryDayDestination> findByItineraryDayIdOrderBySequenceOrderAsc(Long itineraryDayId);
}

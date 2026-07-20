package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.ItineraryDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItineraryDayRepository extends JpaRepository<ItineraryDay, Long> {

    List<ItineraryDay> findByItineraryIdOrderByDayNumberAsc(Long itineraryId);
}

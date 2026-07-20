package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationWeather;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DestinationWeatherRepository extends JpaRepository<DestinationWeather, Long> {

    List<DestinationWeather> findByDestinationId(Long destinationId);
}

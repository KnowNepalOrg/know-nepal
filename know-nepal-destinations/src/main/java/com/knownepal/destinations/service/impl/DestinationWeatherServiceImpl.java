package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.DestinationWeatherRequest;
import com.knownepal.destinations.dto.response.DestinationWeatherResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.DestinationWeatherMapper;
import com.knownepal.destinations.model.DestinationWeather;
import com.knownepal.destinations.model.TouristDestination;
import com.knownepal.destinations.repository.DestinationWeatherRepository;
import com.knownepal.destinations.repository.TouristDestinationRepository;
import com.knownepal.destinations.service.DestinationWeatherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationWeatherServiceImpl implements DestinationWeatherService {

    private final DestinationWeatherRepository repository;
    private final TouristDestinationRepository destinationRepository;

    @Override
    public List<DestinationWeatherResponse> findByDestinationId(Long destinationId) {
        return repository.findByDestinationId(destinationId).stream()
                .map(DestinationWeatherMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public DestinationWeatherResponse create(Long destinationId, DestinationWeatherRequest request) {
        TouristDestination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + destinationId));
        DestinationWeather entity = DestinationWeather.builder()
                .destination(destination)
                .weatherSeason(request.getWeatherSeason())
                .avgTempCelsius(request.getAvgTempCelsius())
                .minTempCelsius(request.getMinTempCelsius())
                .maxTempCelsius(request.getMaxTempCelsius())
                .rainfallMm(request.getRainfallMm())
                .conditions(request.getConditions())
                .isRecommended(request.getIsRecommended() != null ? request.getIsRecommended() : false)
                .build();
        return DestinationWeatherMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public DestinationWeatherResponse update(Long id, DestinationWeatherRequest request) {
        DestinationWeather entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Weather not found with id: " + id));
        entity.setWeatherSeason(request.getWeatherSeason());
        entity.setAvgTempCelsius(request.getAvgTempCelsius());
        entity.setMinTempCelsius(request.getMinTempCelsius());
        entity.setMaxTempCelsius(request.getMaxTempCelsius());
        entity.setRainfallMm(request.getRainfallMm());
        entity.setConditions(request.getConditions());
        entity.setIsRecommended(request.getIsRecommended() != null ? request.getIsRecommended() : entity.getIsRecommended());
        return DestinationWeatherMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Weather not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

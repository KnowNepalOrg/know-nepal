package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.ItineraryDayRequest;
import com.knownepal.destinations.dto.response.ItineraryDayResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.ItineraryDayMapper;
import com.knownepal.destinations.model.DestinationItinerary;
import com.knownepal.destinations.model.ItineraryDay;
import com.knownepal.destinations.repository.DestinationItineraryRepository;
import com.knownepal.destinations.repository.ItineraryDayRepository;
import com.knownepal.destinations.service.ItineraryDayService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItineraryDayServiceImpl implements ItineraryDayService {

    private final ItineraryDayRepository repository;
    private final DestinationItineraryRepository itineraryRepository;

    @Override
    public List<ItineraryDayResponse> findByItineraryId(Long itineraryId) {
        return repository.findByItineraryIdOrderByDayNumberAsc(itineraryId).stream()
                .map(ItineraryDayMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ItineraryDayResponse findById(Long id) {
        ItineraryDay entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary day not found with id: " + id));
        return ItineraryDayMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public ItineraryDayResponse create(Long itineraryId, ItineraryDayRequest request) {
        DestinationItinerary itinerary = itineraryRepository.findById(itineraryId)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id: " + itineraryId));
        ItineraryDay entity = ItineraryDay.builder()
                .itinerary(itinerary)
                .dayNumber(request.getDayNumber())
                .title(request.getTitle())
                .description(request.getDescription())
                .accommodation(request.getAccommodation())
                .meals(request.getMeals())
                .distanceKm(request.getDistanceKm())
                .dayDestinations(new ArrayList<>())
                .build();
        return ItineraryDayMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public ItineraryDayResponse update(Long id, ItineraryDayRequest request) {
        ItineraryDay entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary day not found with id: " + id));
        entity.setDayNumber(request.getDayNumber());
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setAccommodation(request.getAccommodation());
        entity.setMeals(request.getMeals());
        entity.setDistanceKm(request.getDistanceKm());
        return ItineraryDayMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Itinerary day not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

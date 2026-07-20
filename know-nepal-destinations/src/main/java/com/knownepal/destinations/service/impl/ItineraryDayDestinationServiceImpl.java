package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.ItineraryDayDestinationRequest;
import com.knownepal.destinations.dto.response.ItineraryDayDestinationResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.ItineraryDayDestinationMapper;
import com.knownepal.destinations.model.ItineraryDay;
import com.knownepal.destinations.model.ItineraryDayDestination;
import com.knownepal.destinations.model.TouristDestination;
import com.knownepal.destinations.repository.ItineraryDayRepository;
import com.knownepal.destinations.repository.ItineraryDayDestinationRepository;
import com.knownepal.destinations.repository.TouristDestinationRepository;
import com.knownepal.destinations.service.ItineraryDayDestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ItineraryDayDestinationServiceImpl implements ItineraryDayDestinationService {

    private final ItineraryDayDestinationRepository repository;
    private final ItineraryDayRepository dayRepository;
    private final TouristDestinationRepository destinationRepository;

    @Override
    public List<ItineraryDayDestinationResponse> findByDayId(Long dayId) {
        return repository.findByItineraryDayIdOrderBySequenceOrderAsc(dayId).stream()
                .map(ItineraryDayDestinationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public ItineraryDayDestinationResponse create(Long dayId, ItineraryDayDestinationRequest request) {
        ItineraryDay day = dayRepository.findById(dayId)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary day not found with id: " + dayId));
        TouristDestination destination = destinationRepository.findById(request.getDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + request.getDestinationId()));
        ItineraryDayDestination entity = ItineraryDayDestination.builder()
                .itineraryDay(day)
                .destination(destination)
                .sequenceOrder(request.getSequenceOrder())
                .notes(request.getNotes())
                .build();
        return ItineraryDayDestinationMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Itinerary day destination not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

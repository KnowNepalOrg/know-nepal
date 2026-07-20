package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.NearbyDestinationRequest;
import com.knownepal.destinations.dto.response.NearbyDestinationResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.NearbyDestinationMapper;
import com.knownepal.destinations.model.NearbyDestination;
import com.knownepal.destinations.model.TouristDestination;
import com.knownepal.destinations.repository.NearbyDestinationRepository;
import com.knownepal.destinations.repository.TouristDestinationRepository;
import com.knownepal.destinations.service.NearbyDestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class NearbyDestinationServiceImpl implements NearbyDestinationService {

    private final NearbyDestinationRepository repository;
    private final TouristDestinationRepository destinationRepository;

    @Override
    public List<NearbyDestinationResponse> findByDestinationId(Long destinationId) {
        return repository.findByDestinationId(destinationId).stream()
                .map(NearbyDestinationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public NearbyDestinationResponse create(Long destinationId, NearbyDestinationRequest request) {
        TouristDestination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + destinationId));
        TouristDestination nearbyDest = destinationRepository.findById(request.getNearbyDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException("Nearby destination not found with id: " + request.getNearbyDestinationId()));
        NearbyDestination entity = NearbyDestination.builder()
                .destination(destination)
                .nearbyDestination(nearbyDest)
                .distanceKm(request.getDistanceKm())
                .travelTimeMinutes(request.getTravelTimeMinutes())
                .travelMode(request.getTravelMode())
                .build();
        return NearbyDestinationMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Nearby destination not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

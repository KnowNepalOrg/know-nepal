package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.RouteDestinationRequest;
import com.knownepal.destinations.dto.response.RouteDestinationResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.RouteDestinationMapper;
import com.knownepal.destinations.model.RouteDestination;
import com.knownepal.destinations.model.TouristDestination;
import com.knownepal.destinations.model.TrekkingRoute;
import com.knownepal.destinations.repository.RouteDestinationRepository;
import com.knownepal.destinations.repository.TouristDestinationRepository;
import com.knownepal.destinations.repository.TrekkingRouteRepository;
import com.knownepal.destinations.service.RouteDestinationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RouteDestinationServiceImpl implements RouteDestinationService {

    private final RouteDestinationRepository repository;
    private final TrekkingRouteRepository routeRepository;
    private final TouristDestinationRepository destinationRepository;

    @Override
    public List<RouteDestinationResponse> findByRouteId(Long routeId) {
        return repository.findByRouteIdOrderBySequenceOrderAsc(routeId).stream()
                .map(RouteDestinationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public RouteDestinationResponse create(Long routeId, RouteDestinationRequest request) {
        TrekkingRoute route = routeRepository.findById(routeId)
                .orElseThrow(() -> new ResourceNotFoundException("Route not found with id: " + routeId));
        TouristDestination destination = destinationRepository.findById(request.getDestinationId())
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + request.getDestinationId()));
        RouteDestination entity = RouteDestination.builder()
                .route(route)
                .destination(destination)
                .sequenceOrder(request.getSequenceOrder())
                .isOvernightStop(request.getIsOvernightStop() != null ? request.getIsOvernightStop() : false)
                .build();
        return RouteDestinationMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Route destination not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.TrekkingRouteRequest;
import com.knownepal.destinations.dto.response.TrekkingRouteResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.TrekkingRouteMapper;
import com.knownepal.destinations.model.RouteDestination;
import com.knownepal.destinations.model.TouristDestination;
import com.knownepal.destinations.model.TrekkingRoute;
import com.knownepal.destinations.repository.RouteDestinationRepository;
import com.knownepal.destinations.repository.TouristDestinationRepository;
import com.knownepal.destinations.repository.TrekkingRouteRepository;
import com.knownepal.destinations.service.TrekkingRouteService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TrekkingRouteServiceImpl implements TrekkingRouteService {

    private final TrekkingRouteRepository repository;
    private final TouristDestinationRepository destinationRepository;
    private final RouteDestinationRepository routeDestinationRepository;

    @Override
    public List<TrekkingRouteResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream()
                .map(TrekkingRouteMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TrekkingRouteResponse findById(Long id) {
        TrekkingRoute entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trekking route not found with id: " + id));
        return TrekkingRouteMapper.toResponse(entity);
    }

    @Override
    public TrekkingRouteResponse findBySlug(String slug) {
        TrekkingRoute entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Trekking route not found with slug: " + slug));
        return TrekkingRouteMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public TrekkingRouteResponse create(TrekkingRouteRequest request) {
        TrekkingRoute entity = TrekkingRoute.builder()
                .slug(generateSlug(request.getName()))
                .name(request.getName())
                .description(request.getDescription())
                .difficultyLevel(request.getDifficultyLevel())
                .distanceKm(request.getDistanceKm())
                .durationDays(request.getDurationDays())
                .maxAltitudeMeters(request.getMaxAltitudeMeters())
                .bestSeason(request.getBestSeason())
                .isPopular(request.getIsPopular() != null ? request.getIsPopular() : false)
                .build();
        entity = repository.save(entity);

        if (request.getDestinationIds() != null && !request.getDestinationIds().isEmpty()) {
            int order = 1;
            for (Long destId : request.getDestinationIds()) {
                TouristDestination destination = destinationRepository.findById(destId)
                        .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + destId));
                RouteDestination rd = RouteDestination.builder()
                        .route(entity)
                        .destination(destination)
                        .sequenceOrder(order++)
                        .build();
                routeDestinationRepository.save(rd);
            }
        }

        return TrekkingRouteMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public TrekkingRouteResponse update(Long id, TrekkingRouteRequest request) {
        TrekkingRoute entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Trekking route not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setDifficultyLevel(request.getDifficultyLevel());
        entity.setDistanceKm(request.getDistanceKm());
        entity.setDurationDays(request.getDurationDays());
        entity.setMaxAltitudeMeters(request.getMaxAltitudeMeters());
        entity.setBestSeason(request.getBestSeason());
        if (request.getIsPopular() != null) {
            entity.setIsPopular(request.getIsPopular());
        }

        if (request.getDestinationIds() != null) {
            List<RouteDestination> existing = routeDestinationRepository.findByRouteIdOrderBySequenceOrderAsc(id);
            routeDestinationRepository.deleteAll(existing);

            int order = 1;
            for (Long destId : request.getDestinationIds()) {
                TouristDestination destination = destinationRepository.findById(destId)
                        .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + destId));
                RouteDestination rd = RouteDestination.builder()
                        .route(entity)
                        .destination(destination)
                        .sequenceOrder(order++)
                        .build();
                routeDestinationRepository.save(rd);
            }
        }

        return TrekkingRouteMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Trekking route not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public List<TrekkingRouteResponse> search(String query, Pageable pageable) {
        Specification<TrekkingRoute> spec = (root, cq, cb) -> {
            String pattern = "%" + query.toLowerCase() + "%";
            Predicate namePredicate = cb.like(cb.lower(root.get("name")), pattern);
            Predicate descPredicate = cb.like(cb.lower(root.get("description")), pattern);
            return cb.or(namePredicate, descPredicate);
        };
        return repository.findAll(spec, pageable).stream()
                .map(TrekkingRouteMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrekkingRouteResponse> findByFilters(Map<String, String> filters, Pageable pageable) {
        Specification<TrekkingRoute> spec = (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filters.containsKey("difficultyLevel")) {
                predicates.add(cb.equal(root.get("difficultyLevel"), filters.get("difficultyLevel")));
            }
            if (filters.containsKey("bestSeason")) {
                predicates.add(cb.equal(root.get("bestSeason"), filters.get("bestSeason")));
            }
            if (filters.containsKey("isPopular")) {
                predicates.add(cb.equal(root.get("isPopular"), Boolean.parseBoolean(filters.get("isPopular"))));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return repository.findAll(spec, pageable).stream()
                .map(TrekkingRouteMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public long count() {
        return repository.count();
    }

    private String generateSlug(String name) {
        String slug = name.toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "");
        String baseSlug = slug;
        int counter = 1;
        while (repository.existsBySlug(slug)) {
            slug = baseSlug + "-" + counter++;
        }
        return slug;
    }
}

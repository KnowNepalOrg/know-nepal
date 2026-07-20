package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.common.SlugUtil;
import com.knownepal.destinations.dto.request.DestinationItineraryRequest;
import com.knownepal.destinations.dto.response.DestinationItineraryResponse;
import com.knownepal.destinations.exception.ConflictException;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.DestinationItineraryMapper;
import com.knownepal.destinations.model.DestinationItinerary;
import com.knownepal.destinations.repository.DestinationItineraryRepository;
import com.knownepal.destinations.service.DestinationItineraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationItineraryServiceImpl implements DestinationItineraryService {

    private final DestinationItineraryRepository repository;

    @Override
    public List<DestinationItineraryResponse> findAll(Pageable pageable) {
        Page<DestinationItinerary> page = repository.findAll(pageable);
        return page.getContent().stream()
                .map(DestinationItineraryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DestinationItineraryResponse findById(Long id) {
        DestinationItinerary entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id: " + id));
        return DestinationItineraryMapper.toResponse(entity);
    }

    @Override
    public DestinationItineraryResponse findBySlug(String slug) {
        DestinationItinerary entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with slug: " + slug));
        return DestinationItineraryMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public DestinationItineraryResponse create(DestinationItineraryRequest request) {
        String slug = SlugUtil.toSlug(request.getName());
        if (repository.existsBySlug(slug)) {
            throw new ConflictException("Itinerary already exists with slug: " + slug);
        }
        DestinationItinerary entity = DestinationItinerary.builder()
                .slug(slug)
                .name(request.getName())
                .description(request.getDescription())
                .durationDays(request.getDurationDays())
                .difficultyLevel(request.getDifficultyLevel())
                .bestSeason(request.getBestSeason())
                .isPopular(request.getIsPopular() != null ? request.getIsPopular() : false)
                .days(new ArrayList<>())
                .build();
        return DestinationItineraryMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public DestinationItineraryResponse update(Long id, DestinationItineraryRequest request) {
        DestinationItinerary entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Itinerary not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setSlug(SlugUtil.toSlug(request.getName()));
        entity.setDurationDays(request.getDurationDays());
        entity.setDifficultyLevel(request.getDifficultyLevel());
        entity.setBestSeason(request.getBestSeason());
        entity.setIsPopular(request.getIsPopular() != null ? request.getIsPopular() : entity.getIsPopular());
        return DestinationItineraryMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Itinerary not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }
}

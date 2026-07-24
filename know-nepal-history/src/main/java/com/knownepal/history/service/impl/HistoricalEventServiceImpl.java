package com.knownepal.history.service.impl;

import com.knownepal.history.dto.request.HistoricalEventRequest;
import com.knownepal.history.dto.response.HistoricalEventResponse;
import com.knownepal.history.exception.ResourceNotFoundException;
import com.knownepal.history.mapper.HistoricalEventMapper;
import com.knownepal.history.model.*;
import com.knownepal.history.repository.DynastyRepository;
import com.knownepal.history.repository.HistoricalEraRepository;
import com.knownepal.history.repository.HistoricalEventRepository;
import com.knownepal.history.service.HistoricalEventService;
import com.knownepal.history.specification.SpecificationFactory;
import com.knownepal.history.util.SlugUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class HistoricalEventServiceImpl implements HistoricalEventService {

    private final HistoricalEventRepository repository;
    private final HistoricalEraRepository eraRepository;
    private final DynastyRepository dynastyRepository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "events", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<HistoricalEventResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<HistoricalEvent>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(HistoricalEventMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<HistoricalEvent>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoricalEventResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(HistoricalEventMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "events", key = "'id:' + #id")
    public HistoricalEventResponse findById(Long id) {
        HistoricalEvent entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historical event not found with id: " + id));
        return HistoricalEventMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "events", key = "'slug:' + #slug")
    public HistoricalEventResponse findBySlug(String slug) {
        HistoricalEvent entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Historical event not found with slug: " + slug));
        return HistoricalEventMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "events", allEntries = true)
    public HistoricalEventResponse create(HistoricalEventRequest request) {
        HistoricalEra era = eraRepository.findById(request.getEraId())
                .orElseThrow(() -> new ResourceNotFoundException("Historical era not found with id: " + request.getEraId()));
        HistoricalEvent entity = new HistoricalEvent();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setEventType(EventType.valueOf(request.getEventType()));
        entity.setEra(era);
        if (request.getDynastyId() != null) {
            Dynasty dynasty = dynastyRepository.findById(request.getDynastyId())
                    .orElseThrow(() -> new ResourceNotFoundException("Dynasty not found with id: " + request.getDynastyId()));
            entity.setDynasty(dynasty);
        }
        entity.setEventYear(request.getEventYear());
        entity.setEndYear(request.getEndYear());
        entity.setLocation(request.getLocation());
        entity.setSignificance(request.getSignificance());
        entity.setKeyFiguresInvolved(request.getKeyFiguresInvolved());
        entity.setOutcome(request.getOutcome());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return HistoricalEventMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "events", allEntries = true)
    public HistoricalEventResponse update(Long id, HistoricalEventRequest request) {
        HistoricalEvent entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historical event not found with id: " + id));
        HistoricalEra era = eraRepository.findById(request.getEraId())
                .orElseThrow(() -> new ResourceNotFoundException("Historical era not found with id: " + request.getEraId()));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setEventType(EventType.valueOf(request.getEventType()));
        entity.setEra(era);
        if (request.getDynastyId() != null) {
            Dynasty dynasty = dynastyRepository.findById(request.getDynastyId())
                    .orElseThrow(() -> new ResourceNotFoundException("Dynasty not found with id: " + request.getDynastyId()));
            entity.setDynasty(dynasty);
        } else {
            entity.setDynasty(null);
        }
        entity.setEventYear(request.getEventYear());
        entity.setEndYear(request.getEndYear());
        entity.setLocation(request.getLocation());
        entity.setSignificance(request.getSignificance());
        entity.setKeyFiguresInvolved(request.getKeyFiguresInvolved());
        entity.setOutcome(request.getOutcome());
        entity.setIsFeatured(request.getIsFeatured());
        return HistoricalEventMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "events", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Historical event not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

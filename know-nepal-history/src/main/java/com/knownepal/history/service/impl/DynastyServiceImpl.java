package com.knownepal.history.service.impl;

import com.knownepal.history.dto.request.DynastyRequest;
import com.knownepal.history.dto.response.DynastyResponse;
import com.knownepal.history.exception.ResourceNotFoundException;
import com.knownepal.history.mapper.DynastyMapper;
import com.knownepal.history.model.Dynasty;
import com.knownepal.history.model.HistoricalEra;
import com.knownepal.history.model.HistoricalFigure;
import com.knownepal.history.repository.DynastyRepository;
import com.knownepal.history.repository.HistoricalEraRepository;
import com.knownepal.history.repository.HistoricalFigureRepository;
import com.knownepal.history.service.DynastyService;
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
public class DynastyServiceImpl implements DynastyService {

    private final DynastyRepository repository;
    private final HistoricalEraRepository eraRepository;
    private final HistoricalFigureRepository figureRepository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "dynasties", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<DynastyResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<Dynasty>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(DynastyMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<Dynasty>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<DynastyResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(DynastyMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "dynasties", key = "'id:' + #id")
    public DynastyResponse findById(Long id) {
        Dynasty entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dynasty not found with id: " + id));
        return DynastyMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "dynasties", key = "'slug:' + #slug")
    public DynastyResponse findBySlug(String slug) {
        Dynasty entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Dynasty not found with slug: " + slug));
        return DynastyMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "dynasties", allEntries = true)
    public DynastyResponse create(DynastyRequest request) {
        HistoricalEra era = eraRepository.findById(request.getEraId())
                .orElseThrow(() -> new ResourceNotFoundException("Historical era not found with id: " + request.getEraId()));
        Dynasty entity = new Dynasty();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setEra(era);
        if (request.getFounderId() != null) {
            HistoricalFigure founder = figureRepository.findById(request.getFounderId())
                    .orElseThrow(() -> new ResourceNotFoundException("Historical figure not found with id: " + request.getFounderId()));
            entity.setFounder(founder);
        }
        entity.setStartYear(request.getStartYear());
        entity.setEndYear(request.getEndYear());
        entity.setCapital(request.getCapital());
        entity.setKeyAchievements(request.getKeyAchievements());
        entity.setNumberOfRulers(request.getNumberOfRulers());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return DynastyMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "dynasties", allEntries = true)
    public DynastyResponse update(Long id, DynastyRequest request) {
        Dynasty entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dynasty not found with id: " + id));
        HistoricalEra era = eraRepository.findById(request.getEraId())
                .orElseThrow(() -> new ResourceNotFoundException("Historical era not found with id: " + request.getEraId()));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setEra(era);
        if (request.getFounderId() != null) {
            HistoricalFigure founder = figureRepository.findById(request.getFounderId())
                    .orElseThrow(() -> new ResourceNotFoundException("Historical figure not found with id: " + request.getFounderId()));
            entity.setFounder(founder);
        } else {
            entity.setFounder(null);
        }
        entity.setStartYear(request.getStartYear());
        entity.setEndYear(request.getEndYear());
        entity.setCapital(request.getCapital());
        entity.setKeyAchievements(request.getKeyAchievements());
        entity.setNumberOfRulers(request.getNumberOfRulers());
        entity.setIsFeatured(request.getIsFeatured());
        return DynastyMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "dynasties", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Dynasty not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

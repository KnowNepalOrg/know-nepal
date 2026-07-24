package com.knownepal.history.service.impl;

import com.knownepal.history.dto.request.HistoricalFigureRequest;
import com.knownepal.history.dto.response.HistoricalFigureResponse;
import com.knownepal.history.exception.ResourceNotFoundException;
import com.knownepal.history.mapper.HistoricalFigureMapper;
import com.knownepal.history.model.FigureType;
import com.knownepal.history.model.HistoricalFigure;
import com.knownepal.history.repository.HistoricalFigureRepository;
import com.knownepal.history.service.HistoricalFigureService;
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
public class HistoricalFigureServiceImpl implements HistoricalFigureService {

    private final HistoricalFigureRepository repository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "figures", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<HistoricalFigureResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<HistoricalFigure>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(HistoricalFigureMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<HistoricalFigure>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoricalFigureResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(HistoricalFigureMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "figures", key = "'id:' + #id")
    public HistoricalFigureResponse findById(Long id) {
        HistoricalFigure entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historical figure not found with id: " + id));
        return HistoricalFigureMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "figures", key = "'slug:' + #slug")
    public HistoricalFigureResponse findBySlug(String slug) {
        HistoricalFigure entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Historical figure not found with slug: " + slug));
        return HistoricalFigureMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "figures", allEntries = true)
    public HistoricalFigureResponse create(HistoricalFigureRequest request) {
        HistoricalFigure entity = new HistoricalFigure();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setFigureType(FigureType.valueOf(request.getFigureType()));
        entity.setBirthYear(request.getBirthYear());
        entity.setDeathYear(request.getDeathYear());
        entity.setBirthPlace(request.getBirthPlace());
        entity.setKnownFor(request.getKnownFor());
        entity.setKeyAchievements(request.getKeyAchievements());
        entity.setDynastyAffiliation(request.getDynastyAffiliation());
        entity.setEraName(request.getEraName());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return HistoricalFigureMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "figures", allEntries = true)
    public HistoricalFigureResponse update(Long id, HistoricalFigureRequest request) {
        HistoricalFigure entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historical figure not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setFigureType(FigureType.valueOf(request.getFigureType()));
        entity.setBirthYear(request.getBirthYear());
        entity.setDeathYear(request.getDeathYear());
        entity.setBirthPlace(request.getBirthPlace());
        entity.setKnownFor(request.getKnownFor());
        entity.setKeyAchievements(request.getKeyAchievements());
        entity.setDynastyAffiliation(request.getDynastyAffiliation());
        entity.setEraName(request.getEraName());
        entity.setIsFeatured(request.getIsFeatured());
        return HistoricalFigureMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "figures", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Historical figure not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

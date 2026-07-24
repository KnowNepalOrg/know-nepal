package com.knownepal.history.service.impl;

import com.knownepal.history.dto.request.HistoricalEraRequest;
import com.knownepal.history.dto.response.HistoricalEraResponse;
import com.knownepal.history.exception.ResourceNotFoundException;
import com.knownepal.history.mapper.HistoricalEraMapper;
import com.knownepal.history.model.HistoricalEra;
import com.knownepal.history.repository.HistoricalEraRepository;
import com.knownepal.history.service.HistoricalEraService;
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
public class HistoricalEraServiceImpl implements HistoricalEraService {

    private final HistoricalEraRepository repository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "eras", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<HistoricalEraResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<HistoricalEra>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(HistoricalEraMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<HistoricalEra>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<HistoricalEraResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(HistoricalEraMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "eras", key = "'id:' + #id")
    public HistoricalEraResponse findById(Long id) {
        HistoricalEra entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historical era not found with id: " + id));
        return HistoricalEraMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "eras", key = "'slug:' + #slug")
    public HistoricalEraResponse findBySlug(String slug) {
        HistoricalEra entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Historical era not found with slug: " + slug));
        return HistoricalEraMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "eras", allEntries = true)
    public HistoricalEraResponse create(HistoricalEraRequest request) {
        HistoricalEra entity = new HistoricalEra();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStartYear(request.getStartYear());
        entity.setEndYear(request.getEndYear());
        entity.setKeyCharacteristics(request.getKeyCharacteristics());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return HistoricalEraMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "eras", allEntries = true)
    public HistoricalEraResponse update(Long id, HistoricalEraRequest request) {
        HistoricalEra entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Historical era not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setStartYear(request.getStartYear());
        entity.setEndYear(request.getEndYear());
        entity.setKeyCharacteristics(request.getKeyCharacteristics());
        entity.setIsFeatured(request.getIsFeatured());
        return HistoricalEraMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "eras", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Historical era not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

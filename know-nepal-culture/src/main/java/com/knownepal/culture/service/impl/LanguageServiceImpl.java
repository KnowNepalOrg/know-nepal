package com.knownepal.culture.service.impl;

import com.knownepal.culture.dto.request.LanguageRequest;
import com.knownepal.culture.dto.response.LanguageResponse;
import com.knownepal.culture.exception.ResourceNotFoundException;
import com.knownepal.culture.mapper.LanguageMapper;
import com.knownepal.culture.model.Language;
import com.knownepal.culture.model.LanguageFamily;
import com.knownepal.culture.model.LanguageStatus;
import com.knownepal.culture.model.RegionType;
import com.knownepal.culture.repository.LanguageRepository;
import com.knownepal.culture.service.LanguageService;
import com.knownepal.culture.specification.SpecificationFactory;
import com.knownepal.culture.util.SlugUtil;
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
public class LanguageServiceImpl implements LanguageService {

    private final LanguageRepository repository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "languages", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<LanguageResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<Language>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(LanguageMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<Language>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LanguageResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(LanguageMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "languages", key = "'id:' + #id")
    public LanguageResponse findById(Long id) {
        Language entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
        return LanguageMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "languages", key = "'slug:' + #slug")
    public LanguageResponse findBySlug(String slug) {
        Language entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with slug: " + slug));
        return LanguageMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "languages", allEntries = true)
    public LanguageResponse create(LanguageRequest request) {
        Language entity = new Language();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setLanguageFamily(LanguageFamily.valueOf(request.getLanguageFamily()));
        entity.setLanguageStatus(LanguageStatus.valueOf(request.getLanguageStatus()));
        entity.setSpeakersCount(request.getSpeakersCount());
        entity.setScript(request.getScript());
        entity.setWritingSystem(request.getWritingSystem());
        entity.setDialects(request.getDialects());
        entity.setIsOfficial(request.getIsOfficial());
        entity.setIsLinguaFranca(request.getIsLinguaFranca());
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setProvince(request.getProvince());
        entity.setOriginHistory(request.getOriginHistory());
        entity.setCulturalSignificance(request.getCulturalSignificance());
        entity.setEndangeredDetails(request.getEndangeredDetails());
        entity.setPreservationEfforts(request.getPreservationEfforts());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return LanguageMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "languages", allEntries = true)
    public LanguageResponse update(Long id, LanguageRequest request) {
        Language entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setLanguageFamily(LanguageFamily.valueOf(request.getLanguageFamily()));
        entity.setLanguageStatus(LanguageStatus.valueOf(request.getLanguageStatus()));
        entity.setSpeakersCount(request.getSpeakersCount());
        entity.setScript(request.getScript());
        entity.setWritingSystem(request.getWritingSystem());
        entity.setDialects(request.getDialects());
        entity.setIsOfficial(request.getIsOfficial());
        entity.setIsLinguaFranca(request.getIsLinguaFranca());
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setProvince(request.getProvince());
        entity.setOriginHistory(request.getOriginHistory());
        entity.setCulturalSignificance(request.getCulturalSignificance());
        entity.setEndangeredDetails(request.getEndangeredDetails());
        entity.setPreservationEfforts(request.getPreservationEfforts());
        return LanguageMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "languages", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Language not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

package com.knownepal.culture.service.impl;

import com.knownepal.culture.dto.request.TraditionalAttireRequest;
import com.knownepal.culture.dto.response.TraditionalAttireResponse;
import com.knownepal.culture.exception.ResourceNotFoundException;
import com.knownepal.culture.mapper.TraditionalAttireMapper;
import com.knownepal.culture.model.*;
import com.knownepal.culture.repository.EthnicGroupRepository;
import com.knownepal.culture.repository.TraditionalAttireRepository;
import com.knownepal.culture.service.TraditionalAttireService;
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
public class TraditionalAttireServiceImpl implements TraditionalAttireService {

    private final TraditionalAttireRepository repository;
    private final EthnicGroupRepository ethnicGroupRepository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "traditionalAttires", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<TraditionalAttireResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<TraditionalAttire>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(TraditionalAttireMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<TraditionalAttire>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TraditionalAttireResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(TraditionalAttireMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "traditionalAttires", key = "'id:' + #id")
    public TraditionalAttireResponse findById(Long id) {
        TraditionalAttire entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Traditional attire not found with id: " + id));
        return TraditionalAttireMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "traditionalAttires", key = "'slug:' + #slug")
    public TraditionalAttireResponse findBySlug(String slug) {
        TraditionalAttire entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Traditional attire not found with slug: " + slug));
        return TraditionalAttireMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "traditionalAttires", allEntries = true)
    public TraditionalAttireResponse create(TraditionalAttireRequest request) {
        TraditionalAttire entity = new TraditionalAttire();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setGenderType(GenderType.valueOf(request.getGenderType()));
        entity.setAttireOccasion(AttireOccasion.valueOf(request.getAttireOccasion()));
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setProvince(request.getProvince());
        entity.setFabricMaterial(request.getFabricMaterial());
        entity.setColors(request.getColors());
        entity.setPatterns(request.getPatterns());
        entity.setSignificance(request.getSignificance());
        entity.setWearingOccasion(request.getWearingOccasion());
        entity.setHistoricalOrigin(request.getHistoricalOrigin());
        entity.setRegionalVariations(request.getRegionalVariations());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        if (request.getEthnicGroupId() != null) {
            EthnicGroup ethnicGroup = ethnicGroupRepository.findById(request.getEthnicGroupId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ethnic group not found with id: " + request.getEthnicGroupId()));
            entity.setEthnicGroup(ethnicGroup);
        }
        return TraditionalAttireMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "traditionalAttires", allEntries = true)
    public TraditionalAttireResponse update(Long id, TraditionalAttireRequest request) {
        TraditionalAttire entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Traditional attire not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setGenderType(GenderType.valueOf(request.getGenderType()));
        entity.setAttireOccasion(AttireOccasion.valueOf(request.getAttireOccasion()));
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setProvince(request.getProvince());
        entity.setFabricMaterial(request.getFabricMaterial());
        entity.setColors(request.getColors());
        entity.setPatterns(request.getPatterns());
        entity.setSignificance(request.getSignificance());
        entity.setWearingOccasion(request.getWearingOccasion());
        entity.setHistoricalOrigin(request.getHistoricalOrigin());
        entity.setRegionalVariations(request.getRegionalVariations());
        if (request.getEthnicGroupId() != null) {
            EthnicGroup ethnicGroup = ethnicGroupRepository.findById(request.getEthnicGroupId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ethnic group not found with id: " + request.getEthnicGroupId()));
            entity.setEthnicGroup(ethnicGroup);
        } else {
            entity.setEthnicGroup(null);
        }
        return TraditionalAttireMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "traditionalAttires", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Traditional attire not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

package com.knownepal.wildlife.service.impl;

import com.knownepal.wildlife.dto.request.WildlifeSpeciesRequest;
import com.knownepal.wildlife.dto.response.WildlifeSpeciesResponse;
import com.knownepal.wildlife.exception.ResourceNotFoundException;
import com.knownepal.wildlife.mapper.WildlifeSpeciesMapper;
import com.knownepal.wildlife.model.ClassType;
import com.knownepal.wildlife.model.ConservationStatus;
import com.knownepal.wildlife.model.NepalStatus;
import com.knownepal.wildlife.model.WildlifeSpecies;
import com.knownepal.wildlife.repository.WildlifeSpeciesRepository;
import com.knownepal.wildlife.service.WildlifeSpeciesService;
import com.knownepal.wildlife.specification.SpecificationFactory;
import com.knownepal.wildlife.util.SlugUtil;
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
public class WildlifeSpeciesServiceImpl implements WildlifeSpeciesService {

    private final WildlifeSpeciesRepository repository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "species", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<WildlifeSpeciesResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<WildlifeSpecies>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(WildlifeSpeciesMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<WildlifeSpecies>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<WildlifeSpeciesResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(WildlifeSpeciesMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "species", key = "'id:' + #id")
    public WildlifeSpeciesResponse findById(Long id) {
        WildlifeSpecies entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wildlife species not found with id: " + id));
        return WildlifeSpeciesMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "species", key = "'slug:' + #slug")
    public WildlifeSpeciesResponse findBySlug(String slug) {
        WildlifeSpecies entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Wildlife species not found with slug: " + slug));
        return WildlifeSpeciesMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "species", allEntries = true)
    public WildlifeSpeciesResponse create(WildlifeSpeciesRequest request) {
        WildlifeSpecies entity = new WildlifeSpecies();
        entity.setName(request.getName());
        entity.setScientificName(request.getScientificName());
        entity.setDescription(request.getDescription());
        entity.setClassType(ClassType.valueOf(request.getClassType()));
        entity.setConservationStatus(ConservationStatus.valueOf(request.getConservationStatus()));
        if (request.getNepalStatus() != null) {
            entity.setNepalStatus(NepalStatus.valueOf(request.getNepalStatus()));
        }
        entity.setHabitat(request.getHabitat());
        entity.setElevationRange(request.getElevationRange());
        entity.setEstimatedPopulation(request.getEstimatedPopulation());
        entity.setIsEndemic(request.getIsEndemic());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setFunFacts(request.getFunFacts());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return WildlifeSpeciesMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "species", allEntries = true)
    public WildlifeSpeciesResponse update(Long id, WildlifeSpeciesRequest request) {
        WildlifeSpecies entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Wildlife species not found with id: " + id));
        entity.setName(request.getName());
        entity.setScientificName(request.getScientificName());
        entity.setDescription(request.getDescription());
        entity.setClassType(ClassType.valueOf(request.getClassType()));
        entity.setConservationStatus(ConservationStatus.valueOf(request.getConservationStatus()));
        if (request.getNepalStatus() != null) {
            entity.setNepalStatus(NepalStatus.valueOf(request.getNepalStatus()));
        } else {
            entity.setNepalStatus(null);
        }
        entity.setHabitat(request.getHabitat());
        entity.setElevationRange(request.getElevationRange());
        entity.setEstimatedPopulation(request.getEstimatedPopulation());
        entity.setIsEndemic(request.getIsEndemic());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setFunFacts(request.getFunFacts());
        return WildlifeSpeciesMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "species", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Wildlife species not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

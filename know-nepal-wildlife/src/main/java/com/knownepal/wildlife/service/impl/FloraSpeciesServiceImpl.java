package com.knownepal.wildlife.service.impl;

import com.knownepal.wildlife.dto.request.FloraSpeciesRequest;
import com.knownepal.wildlife.dto.response.FloraSpeciesResponse;
import com.knownepal.wildlife.exception.ResourceNotFoundException;
import com.knownepal.wildlife.mapper.FloraSpeciesMapper;
import com.knownepal.wildlife.model.FloraSpecies;
import com.knownepal.wildlife.repository.FloraSpeciesRepository;
import com.knownepal.wildlife.service.FloraSpeciesService;
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
public class FloraSpeciesServiceImpl implements FloraSpeciesService {

    private final FloraSpeciesRepository repository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "flora", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<FloraSpeciesResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<FloraSpecies>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(FloraSpeciesMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<FloraSpecies>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FloraSpeciesResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(FloraSpeciesMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "flora", key = "'id:' + #id")
    public FloraSpeciesResponse findById(Long id) {
        FloraSpecies entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flora species not found with id: " + id));
        return FloraSpeciesMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "flora", key = "'slug:' + #slug")
    public FloraSpeciesResponse findBySlug(String slug) {
        FloraSpecies entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Flora species not found with slug: " + slug));
        return FloraSpeciesMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "flora", allEntries = true)
    public FloraSpeciesResponse create(FloraSpeciesRequest request) {
        FloraSpecies entity = new FloraSpecies();
        entity.setName(request.getName());
        entity.setScientificName(request.getScientificName());
        entity.setDescription(request.getDescription());
        entity.setPlantType(request.getPlantType());
        entity.setFamilyName(request.getFamilyName());
        entity.setHabitat(request.getHabitat());
        entity.setElevationRange(request.getElevationRange());
        entity.setIsEndemic(request.getIsEndemic());
        entity.setIsMedicinal(request.getIsMedicinal());
        entity.setMedicinalUses(request.getMedicinalUses());
        entity.setConservationStatus(request.getConservationStatus());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setFunFacts(request.getFunFacts());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return FloraSpeciesMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "flora", allEntries = true)
    public FloraSpeciesResponse update(Long id, FloraSpeciesRequest request) {
        FloraSpecies entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Flora species not found with id: " + id));
        entity.setName(request.getName());
        entity.setScientificName(request.getScientificName());
        entity.setDescription(request.getDescription());
        entity.setPlantType(request.getPlantType());
        entity.setFamilyName(request.getFamilyName());
        entity.setHabitat(request.getHabitat());
        entity.setElevationRange(request.getElevationRange());
        entity.setIsEndemic(request.getIsEndemic());
        entity.setIsMedicinal(request.getIsMedicinal());
        entity.setMedicinalUses(request.getMedicinalUses());
        entity.setConservationStatus(request.getConservationStatus());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setFunFacts(request.getFunFacts());
        return FloraSpeciesMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "flora", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Flora species not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

package com.knownepal.wildlife.service.impl;

import com.knownepal.wildlife.dto.request.NationalParkRequest;
import com.knownepal.wildlife.dto.response.NationalParkResponse;
import com.knownepal.wildlife.exception.ResourceNotFoundException;
import com.knownepal.wildlife.mapper.NationalParkMapper;
import com.knownepal.wildlife.model.NationalPark;
import com.knownepal.wildlife.model.ProtectedAreaType;
import com.knownepal.wildlife.repository.NationalParkRepository;
import com.knownepal.wildlife.service.NationalParkService;
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
public class NationalParkServiceImpl implements NationalParkService {

    private final NationalParkRepository repository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "parks", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<NationalParkResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<NationalPark>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(NationalParkMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<NationalPark>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<NationalParkResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(NationalParkMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "parks", key = "'id:' + #id")
    public NationalParkResponse findById(Long id) {
        NationalPark entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("National park not found with id: " + id));
        return NationalParkMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "parks", key = "'slug:' + #slug")
    public NationalParkResponse findBySlug(String slug) {
        NationalPark entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("National park not found with slug: " + slug));
        return NationalParkMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "parks", allEntries = true)
    public NationalParkResponse create(NationalParkRequest request) {
        NationalPark entity = new NationalPark();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setAreaType(ProtectedAreaType.valueOf(request.getAreaType()));
        entity.setDistrict(request.getDistrict());
        entity.setProvince(request.getProvince());
        entity.setAreaSqKm(request.getAreaSqKm());
        entity.setBufferZoneSqKm(request.getBufferZoneSqKm());
        entity.setEstablishedYear(request.getEstablishedYear());
        entity.setElevationMinM(request.getElevationMinM());
        entity.setElevationMaxM(request.getElevationMaxM());
        entity.setKeySpecies(request.getKeySpecies());
        entity.setNotableFeatures(request.getNotableFeatures());
        entity.setVisitorCount(request.getVisitorCount());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return NationalParkMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "parks", allEntries = true)
    public NationalParkResponse update(Long id, NationalParkRequest request) {
        NationalPark entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("National park not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setAreaType(ProtectedAreaType.valueOf(request.getAreaType()));
        entity.setDistrict(request.getDistrict());
        entity.setProvince(request.getProvince());
        entity.setAreaSqKm(request.getAreaSqKm());
        entity.setBufferZoneSqKm(request.getBufferZoneSqKm());
        entity.setEstablishedYear(request.getEstablishedYear());
        entity.setElevationMinM(request.getElevationMinM());
        entity.setElevationMaxM(request.getElevationMaxM());
        entity.setKeySpecies(request.getKeySpecies());
        entity.setNotableFeatures(request.getNotableFeatures());
        entity.setVisitorCount(request.getVisitorCount());
        entity.setIsFeatured(request.getIsFeatured());
        return NationalParkMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "parks", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("National park not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

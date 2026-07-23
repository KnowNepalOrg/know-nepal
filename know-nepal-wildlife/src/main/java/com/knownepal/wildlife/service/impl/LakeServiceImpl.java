package com.knownepal.wildlife.service.impl;

import com.knownepal.wildlife.dto.request.LakeRequest;
import com.knownepal.wildlife.dto.response.LakeResponse;
import com.knownepal.wildlife.exception.ResourceNotFoundException;
import com.knownepal.wildlife.mapper.LakeMapper;
import com.knownepal.wildlife.model.Lake;
import com.knownepal.wildlife.model.LakeType;
import com.knownepal.wildlife.repository.LakeRepository;
import com.knownepal.wildlife.service.LakeService;
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
public class LakeServiceImpl implements LakeService {

    private final LakeRepository repository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "lakes", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<LakeResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<Lake>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(LakeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<Lake>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<LakeResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(LakeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "lakes", key = "'id:' + #id")
    public LakeResponse findById(Long id) {
        Lake entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lake not found with id: " + id));
        return LakeMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "lakes", key = "'slug:' + #slug")
    public LakeResponse findBySlug(String slug) {
        Lake entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Lake not found with slug: " + slug));
        return LakeMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "lakes", allEntries = true)
    public LakeResponse create(LakeRequest request) {
        Lake entity = new Lake();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setLakeType(LakeType.valueOf(request.getLakeType()));
        entity.setDistrict(request.getDistrict());
        entity.setProvince(request.getProvince());
        entity.setElevationM(request.getElevationM());
        entity.setAreaSqKm(request.getAreaSqKm());
        entity.setMaxDepthM(request.getMaxDepthM());
        entity.setLengthKm(request.getLengthKm());
        entity.setWidthKm(request.getWidthKm());
        entity.setNotableFeatures(request.getNotableFeatures());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return LakeMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "lakes", allEntries = true)
    public LakeResponse update(Long id, LakeRequest request) {
        Lake entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Lake not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setLakeType(LakeType.valueOf(request.getLakeType()));
        entity.setDistrict(request.getDistrict());
        entity.setProvince(request.getProvince());
        entity.setElevationM(request.getElevationM());
        entity.setAreaSqKm(request.getAreaSqKm());
        entity.setMaxDepthM(request.getMaxDepthM());
        entity.setLengthKm(request.getLengthKm());
        entity.setWidthKm(request.getWidthKm());
        entity.setNotableFeatures(request.getNotableFeatures());
        entity.setIsFeatured(request.getIsFeatured());
        return LakeMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "lakes", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Lake not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

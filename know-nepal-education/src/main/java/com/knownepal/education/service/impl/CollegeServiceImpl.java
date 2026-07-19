package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.CollegeRequest;
import com.knownepal.education.dto.response.CollegeResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.exception.ConflictException;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.CollegeMapper;
import com.knownepal.education.model.College;
import com.knownepal.education.model.CollegeLevel;
import com.knownepal.education.model.CollegeType;
import com.knownepal.education.repository.CollegeRepository;
import com.knownepal.education.service.CollegeService;
import com.knownepal.education.specification.CollegeSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CollegeServiceImpl implements CollegeService {

    private final CollegeRepository repository;

    @Override
    @Cacheable(value = "colleges", key = "'slug-' + #slug")
    public CollegeResponse getBySlug(String slug) {
        College college = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with slug: " + slug));
        return CollegeMapper.toResponse(college);
    }

    @Override
    @Cacheable(value = "colleges", key = "'list-' + #name + '-' + #type + '-' + #level + '-' + #provinceId + '-' + #districtId + '-' + #page + '-' + #size")
    public PagedResponse<CollegeResponse> getAll(String name, CollegeType type, CollegeLevel level,
                                                 Long provinceId, Long districtId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<College> spec = CollegeSpecification.build(name, type, level, provinceId, districtId);
        Page<College> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(CollegeMapper::toResponse).toList(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isFirst(),
                pageResult.isLast()
        );
    }

    @Override
    @Transactional
    @CacheEvict(value = "colleges", allEntries = true)
    public CollegeResponse create(CollegeRequest request) {
        if (repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("College already exists with slug: " + request.getSlug());
        }
        if (request.getCode() != null && repository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("College already exists with code: " + request.getCode());
        }

        College college = CollegeMapper.toEntity(request);
        College saved = repository.save(college);
        return CollegeMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "colleges", key = "'slug-' + #slug")
    public CollegeResponse update(String slug, CollegeRequest request) {
        College college = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with slug: " + slug));

        if (!slug.equals(request.getSlug()) && repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("College already exists with slug: " + request.getSlug());
        }

        CollegeMapper.updateEntity(college, request);
        College saved = repository.save(college);
        return CollegeMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "colleges", allEntries = true)
    public void delete(String slug) {
        College college = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("College not found with slug: " + slug));
        repository.delete(college);
    }
}

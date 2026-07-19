package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.SchoolRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.SchoolResponse;
import com.knownepal.education.exception.ConflictException;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.SchoolMapper;
import com.knownepal.education.model.EducationLevel;
import com.knownepal.education.model.School;
import com.knownepal.education.model.SchoolType;
import com.knownepal.education.repository.SchoolRepository;
import com.knownepal.education.service.SchoolService;
import com.knownepal.education.specification.SchoolSpecification;
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
public class SchoolServiceImpl implements SchoolService {

    private final SchoolRepository repository;

    @Override
    @Cacheable(value = "schools", key = "'slug-' + #slug")
    public SchoolResponse getBySlug(String slug) {
        School school = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("School not found with slug: " + slug));
        return SchoolMapper.toResponse(school);
    }

    @Override
    @Cacheable(value = "schools", key = "'list-' + #name + '-' + #type + '-' + #level + '-' + #provinceId + '-' + #districtId + '-' + #page + '-' + #size")
    public PagedResponse<SchoolResponse> getAll(String name, SchoolType type, EducationLevel level,
                                                Long provinceId, Long districtId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<School> spec = SchoolSpecification.build(name, type, level, provinceId, districtId);
        Page<School> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(SchoolMapper::toResponse).toList(),
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
    @CacheEvict(value = "schools", allEntries = true)
    public SchoolResponse create(SchoolRequest request) {
        if (repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("School already exists with slug: " + request.getSlug());
        }
        if (request.getCode() != null && repository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("School already exists with code: " + request.getCode());
        }

        School school = SchoolMapper.toEntity(request);
        School saved = repository.save(school);
        return SchoolMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "schools", key = "'slug-' + #slug")
    public SchoolResponse update(String slug, SchoolRequest request) {
        School school = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("School not found with slug: " + slug));

        if (!slug.equals(request.getSlug()) && repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("School already exists with slug: " + request.getSlug());
        }

        SchoolMapper.updateEntity(school, request);
        School saved = repository.save(school);
        return SchoolMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "schools", allEntries = true)
    public void delete(String slug) {
        School school = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("School not found with slug: " + slug));
        repository.delete(school);
    }
}

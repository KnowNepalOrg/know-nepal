package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.ScholarshipRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.ScholarshipResponse;
import com.knownepal.education.exception.ConflictException;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.ScholarshipMapper;
import com.knownepal.education.model.Scholarship;
import com.knownepal.education.model.ScholarshipType;
import com.knownepal.education.repository.ScholarshipRepository;
import com.knownepal.education.service.ScholarshipService;
import com.knownepal.education.specification.ScholarshipSpecification;
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
public class ScholarshipServiceImpl implements ScholarshipService {

    private final ScholarshipRepository repository;

    @Override
    @Cacheable(value = "scholarships", key = "'slug-' + #slug")
    public ScholarshipResponse getBySlug(String slug) {
        Scholarship scholarship = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Scholarship not found with slug: " + slug));
        return ScholarshipMapper.toResponse(scholarship);
    }

    @Override
    @Cacheable(value = "scholarships", key = "'list-' + #name + '-' + #type + '-' + #provinceId + '-' + #page + '-' + #size")
    public PagedResponse<ScholarshipResponse> getAll(String name, ScholarshipType type,
                                                      Long provinceId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Scholarship> spec = ScholarshipSpecification.build(name, type, provinceId);
        Page<Scholarship> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(ScholarshipMapper::toResponse).toList(),
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
    @CacheEvict(value = "scholarships", allEntries = true)
    public ScholarshipResponse create(ScholarshipRequest request) {
        if (repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Scholarship already exists with slug: " + request.getSlug());
        }

        Scholarship scholarship = ScholarshipMapper.toEntity(request);
        Scholarship saved = repository.save(scholarship);
        return ScholarshipMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "scholarships", key = "'slug-' + #slug")
    public ScholarshipResponse update(String slug, ScholarshipRequest request) {
        Scholarship scholarship = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Scholarship not found with slug: " + slug));

        if (!slug.equals(request.getSlug()) && repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Scholarship already exists with slug: " + request.getSlug());
        }

        ScholarshipMapper.updateEntity(scholarship, request);
        Scholarship saved = repository.save(scholarship);
        return ScholarshipMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "scholarships", allEntries = true)
    public void delete(String slug) {
        Scholarship scholarship = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Scholarship not found with slug: " + slug));
        repository.delete(scholarship);
    }
}

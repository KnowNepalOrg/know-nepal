package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.UniversityRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.UniversityResponse;
import com.knownepal.education.exception.ConflictException;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.UniversityMapper;
import com.knownepal.education.model.University;
import com.knownepal.education.model.UniversityType;
import com.knownepal.education.repository.UniversityRepository;
import com.knownepal.education.service.UniversityService;
import com.knownepal.education.specification.UniversitySpecification;
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
public class UniversityServiceImpl implements UniversityService {

    private final UniversityRepository repository;

    @Override
    @Cacheable(value = "universities", key = "'slug-' + #slug")
    public UniversityResponse getBySlug(String slug) {
        University university = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("University not found with slug: " + slug));
        return UniversityMapper.toResponse(university);
    }

    @Override
    @Cacheable(value = "universities", key = "'list-' + #name + '-' + #type + '-' + #provinceId + '-' + #page + '-' + #size")
    public PagedResponse<UniversityResponse> getAll(String name, UniversityType type, Long provinceId,
                                                    int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<University> spec = UniversitySpecification.build(name, type, provinceId);
        Page<University> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(UniversityMapper::toResponse).toList(),
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
    @CacheEvict(value = "universities", allEntries = true)
    public UniversityResponse create(UniversityRequest request) {
        if (repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("University already exists with slug: " + request.getSlug());
        }
        if (request.getCode() != null && repository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("University already exists with code: " + request.getCode());
        }

        University university = UniversityMapper.toEntity(request);
        University saved = repository.save(university);
        return UniversityMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "universities", key = "'slug-' + #slug")
    public UniversityResponse update(String slug, UniversityRequest request) {
        University university = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("University not found with slug: " + slug));

        if (!slug.equals(request.getSlug()) && repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("University already exists with slug: " + request.getSlug());
        }

        UniversityMapper.updateEntity(university, request);
        University saved = repository.save(university);
        return UniversityMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "universities", allEntries = true)
    public void delete(String slug) {
        University university = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("University not found with slug: " + slug));
        repository.delete(university);
    }
}

package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.ProgramRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.ProgramResponse;
import com.knownepal.education.exception.ConflictException;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.ProgramMapper;
import com.knownepal.education.model.InstitutionType;
import com.knownepal.education.model.Program;
import com.knownepal.education.model.ProgramLevel;
import com.knownepal.education.repository.ProgramRepository;
import com.knownepal.education.service.ProgramService;
import com.knownepal.education.specification.ProgramSpecification;
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
public class ProgramServiceImpl implements ProgramService {

    private final ProgramRepository repository;

    @Override
    @Cacheable(value = "programs", key = "'slug-' + #slug")
    public ProgramResponse getBySlug(String slug) {
        Program program = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found with slug: " + slug));
        return ProgramMapper.toResponse(program);
    }

    @Override
    @Cacheable(value = "programs", key = "'list-' + #name + '-' + #level + '-' + #faculty + '-' + #institutionType + '-' + #page + '-' + #size")
    public PagedResponse<ProgramResponse> getAll(String name, ProgramLevel level, String faculty,
                                                 InstitutionType institutionType, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Program> spec = ProgramSpecification.build(name, level, faculty, institutionType);
        Page<Program> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(ProgramMapper::toResponse).toList(),
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
    @CacheEvict(value = "programs", allEntries = true)
    public ProgramResponse create(ProgramRequest request) {
        if (repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Program already exists with slug: " + request.getSlug());
        }
        if (request.getCode() != null && repository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("Program already exists with code: " + request.getCode());
        }

        Program program = ProgramMapper.toEntity(request);
        Program saved = repository.save(program);
        return ProgramMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "programs", key = "'slug-' + #slug")
    public ProgramResponse update(String slug, ProgramRequest request) {
        Program program = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found with slug: " + slug));

        if (!slug.equals(request.getSlug()) && repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Program already exists with slug: " + request.getSlug());
        }

        ProgramMapper.updateEntity(program, request);
        Program saved = repository.save(program);
        return ProgramMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "programs", allEntries = true)
    public void delete(String slug) {
        Program program = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found with slug: " + slug));
        repository.delete(program);
    }
}

package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.EntranceExamRequest;
import com.knownepal.education.dto.response.EntranceExamResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.exception.ConflictException;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.EntranceExamMapper;
import com.knownepal.education.model.EntranceExam;
import com.knownepal.education.model.ExamFormat;
import com.knownepal.education.repository.EntranceExamRepository;
import com.knownepal.education.service.EntranceExamService;
import com.knownepal.education.specification.EntranceExamSpecification;
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
public class EntranceExamServiceImpl implements EntranceExamService {

    private final EntranceExamRepository repository;

    @Override
    @Cacheable(value = "entranceExams", key = "'slug-' + #slug")
    public EntranceExamResponse getBySlug(String slug) {
        EntranceExam entranceExam = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Entrance exam not found with slug: " + slug));
        return EntranceExamMapper.toResponse(entranceExam);
    }

    @Override
    @Cacheable(value = "entranceExams", key = "'list-' + #name + '-' + #format + '-' + #boardId + '-' + #page + '-' + #size")
    public PagedResponse<EntranceExamResponse> getAll(String name, ExamFormat format,
                                                      Long boardId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<EntranceExam> spec = EntranceExamSpecification.build(name, format, boardId);
        Page<EntranceExam> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(EntranceExamMapper::toResponse).toList(),
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
    @CacheEvict(value = "entranceExams", allEntries = true)
    public EntranceExamResponse create(EntranceExamRequest request) {
        if (repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Entrance exam already exists with slug: " + request.getSlug());
        }
        if (request.getCode() != null && repository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("Entrance exam already exists with code: " + request.getCode());
        }

        EntranceExam entranceExam = EntranceExamMapper.toEntity(request);
        EntranceExam saved = repository.save(entranceExam);
        return EntranceExamMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "entranceExams", key = "'slug-' + #slug")
    public EntranceExamResponse update(String slug, EntranceExamRequest request) {
        EntranceExam entranceExam = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Entrance exam not found with slug: " + slug));

        if (!slug.equals(request.getSlug()) && repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Entrance exam already exists with slug: " + request.getSlug());
        }

        EntranceExamMapper.updateEntity(entranceExam, request);
        EntranceExam saved = repository.save(entranceExam);
        return EntranceExamMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "entranceExams", allEntries = true)
    public void delete(String slug) {
        EntranceExam entranceExam = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Entrance exam not found with slug: " + slug));
        repository.delete(entranceExam);
    }
}

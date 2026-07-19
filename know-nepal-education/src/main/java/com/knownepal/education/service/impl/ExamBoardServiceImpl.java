package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.ExamBoardRequest;
import com.knownepal.education.dto.response.ExamBoardResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.exception.ConflictException;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.ExamBoardMapper;
import com.knownepal.education.model.BoardCategory;
import com.knownepal.education.model.ExamBoard;
import com.knownepal.education.repository.ExamBoardRepository;
import com.knownepal.education.service.ExamBoardService;
import com.knownepal.education.specification.ExamBoardSpecification;
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
public class ExamBoardServiceImpl implements ExamBoardService {

    private final ExamBoardRepository repository;

    @Override
    @Cacheable(value = "examBoards", key = "'slug-' + #slug")
    public ExamBoardResponse getBySlug(String slug) {
        ExamBoard examBoard = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Exam board not found with slug: " + slug));
        return ExamBoardMapper.toResponse(examBoard);
    }

    @Override
    @Cacheable(value = "examBoards", key = "'list-' + #name + '-' + #category + '-' + #provinceId + '-' + #page + '-' + #size")
    public PagedResponse<ExamBoardResponse> getAll(String name, BoardCategory category,
                                                    Long provinceId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<ExamBoard> spec = ExamBoardSpecification.build(name, category, provinceId);
        Page<ExamBoard> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(ExamBoardMapper::toResponse).toList(),
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
    @CacheEvict(value = "examBoards", allEntries = true)
    public ExamBoardResponse create(ExamBoardRequest request) {
        if (repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Exam board already exists with slug: " + request.getSlug());
        }
        if (request.getCode() != null && repository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("Exam board already exists with code: " + request.getCode());
        }

        ExamBoard examBoard = ExamBoardMapper.toEntity(request);
        ExamBoard saved = repository.save(examBoard);
        return ExamBoardMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "examBoards", key = "'slug-' + #slug")
    public ExamBoardResponse update(String slug, ExamBoardRequest request) {
        ExamBoard examBoard = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Exam board not found with slug: " + slug));

        if (!slug.equals(request.getSlug()) && repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Exam board already exists with slug: " + request.getSlug());
        }

        ExamBoardMapper.updateEntity(examBoard, request);
        ExamBoard saved = repository.save(examBoard);
        return ExamBoardMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "examBoards", allEntries = true)
    public void delete(String slug) {
        ExamBoard examBoard = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Exam board not found with slug: " + slug));
        repository.delete(examBoard);
    }
}

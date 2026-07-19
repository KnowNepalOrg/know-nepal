package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.FeeBreakdownRequest;
import com.knownepal.education.dto.response.FeeBreakdownResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.FeeBreakdownMapper;
import com.knownepal.education.model.FeeBreakdown;
import com.knownepal.education.model.FeeComponent;
import com.knownepal.education.repository.FeeBreakdownRepository;
import com.knownepal.education.service.FeeBreakdownService;
import com.knownepal.education.specification.FeeBreakdownSpecification;
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
public class FeeBreakdownServiceImpl implements FeeBreakdownService {

    private final FeeBreakdownRepository repository;

    @Override
    @Cacheable(value = "feeBreakdowns", key = "'list-' + #programId + '-' + #institutionId + '-' + #component + '-' + #academicYear + '-' + #page + '-' + #size")
    public PagedResponse<FeeBreakdownResponse> getAll(Long programId, Long institutionId,
                                                      FeeComponent component, String academicYear,
                                                      int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<FeeBreakdown> spec = FeeBreakdownSpecification.build(programId, institutionId, component, academicYear);
        Page<FeeBreakdown> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(FeeBreakdownMapper::toResponse).toList(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isFirst(),
                pageResult.isLast()
        );
    }

    @Override
    @Cacheable(value = "feeBreakdowns", key = "'id-' + #id")
    public FeeBreakdownResponse getById(Long id) {
        FeeBreakdown feeBreakdown = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee breakdown not found with id: " + id));
        return FeeBreakdownMapper.toResponse(feeBreakdown);
    }

    @Override
    @Transactional
    @CacheEvict(value = "feeBreakdowns", allEntries = true)
    public FeeBreakdownResponse create(FeeBreakdownRequest request) {
        FeeBreakdown feeBreakdown = FeeBreakdownMapper.toEntity(request);
        FeeBreakdown saved = repository.save(feeBreakdown);
        return FeeBreakdownMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "feeBreakdowns", key = "'id-' + #id")
    public FeeBreakdownResponse update(Long id, FeeBreakdownRequest request) {
        FeeBreakdown feeBreakdown = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee breakdown not found with id: " + id));

        FeeBreakdownMapper.updateEntity(feeBreakdown, request);
        FeeBreakdown saved = repository.save(feeBreakdown);
        return FeeBreakdownMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "feeBreakdowns", allEntries = true)
    public void delete(Long id) {
        FeeBreakdown feeBreakdown = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee breakdown not found with id: " + id));
        repository.delete(feeBreakdown);
    }
}

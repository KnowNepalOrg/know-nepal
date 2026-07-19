package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.RankingRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.RankingResponse;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.RankingMapper;
import com.knownepal.education.model.Ranking;
import com.knownepal.education.model.RankingSource;
import com.knownepal.education.repository.RankingRepository;
import com.knownepal.education.service.RankingService;
import com.knownepal.education.specification.RankingSpecification;
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
public class RankingServiceImpl implements RankingService {

    private final RankingRepository repository;

    @Override
    @Cacheable(value = "rankings", key = "'list-' + #institutionType + '-' + #institutionId + '-' + #source + '-' + #year + '-' + #page + '-' + #size")
    public PagedResponse<RankingResponse> getAll(String institutionType, Long institutionId,
                                                  RankingSource source, String year,
                                                  int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Ranking> spec = RankingSpecification.build(institutionType, institutionId, source, year);
        Page<Ranking> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(RankingMapper::toResponse).toList(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isFirst(),
                pageResult.isLast()
        );
    }

    @Override
    @Cacheable(value = "rankings", key = "'id-' + #id")
    public RankingResponse getById(Long id) {
        Ranking ranking = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ranking not found with id: " + id));
        return RankingMapper.toResponse(ranking);
    }

    @Override
    @Transactional
    @CacheEvict(value = "rankings", allEntries = true)
    public RankingResponse create(RankingRequest request) {
        Ranking ranking = RankingMapper.toEntity(request);
        Ranking saved = repository.save(ranking);
        return RankingMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "rankings", key = "'id-' + #id")
    public RankingResponse update(Long id, RankingRequest request) {
        Ranking ranking = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ranking not found with id: " + id));

        RankingMapper.updateEntity(ranking, request);
        Ranking saved = repository.save(ranking);
        return RankingMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "rankings", allEntries = true)
    public void delete(Long id) {
        Ranking ranking = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ranking not found with id: " + id));
        repository.delete(ranking);
    }
}

package com.knownepal.culture.service.impl;

import com.knownepal.culture.dto.request.FestivalRequest;
import com.knownepal.culture.dto.response.FestivalResponse;
import com.knownepal.culture.exception.ResourceNotFoundException;
import com.knownepal.culture.mapper.FestivalMapper;
import com.knownepal.culture.model.*;
import com.knownepal.culture.repository.FestivalRepository;
import com.knownepal.culture.service.FestivalService;
import com.knownepal.culture.specification.SpecificationFactory;
import com.knownepal.culture.util.SlugUtil;
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
public class FestivalServiceImpl implements FestivalService {

    private final FestivalRepository repository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "festivals", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<FestivalResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<Festival>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(FestivalMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<Festival>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<FestivalResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(FestivalMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "festivals", key = "'id:' + #id")
    public FestivalResponse findById(Long id) {
        Festival entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + id));
        return FestivalMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "festivals", key = "'slug:' + #slug")
    public FestivalResponse findBySlug(String slug) {
        Festival entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Festival not found with slug: " + slug));
        return FestivalMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "festivals", allEntries = true)
    public FestivalResponse create(FestivalRequest request) {
        Festival entity = new Festival();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setFestivalType(FestivalType.valueOf(request.getFestivalType()));
        entity.setCultureSeason(CultureSeason.valueOf(request.getCultureSeason()));
        entity.setMonth(request.getMonth());
        entity.setDay(request.getDay());
        entity.setDurationDays(request.getDurationDays());
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setIsNationalHoliday(request.getIsNationalHoliday());
        entity.setIsPublicHoliday(request.getIsPublicHoliday());
        entity.setSignificance(request.getSignificance());
        entity.setRituals(request.getRituals());
        entity.setModernCelebrations(request.getModernCelebrations());
        entity.setEthnicGroupsInvolved(request.getEthnicGroupsInvolved());
        entity.setProvince(request.getProvince());
        entity.setDistrict(request.getDistrict());
        entity.setIsPopular(request.getIsPopular());
        entity.setIsFeatured(request.getIsFeatured());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        return FestivalMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "festivals", allEntries = true)
    public FestivalResponse update(Long id, FestivalRequest request) {
        Festival entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Festival not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setFestivalType(FestivalType.valueOf(request.getFestivalType()));
        entity.setCultureSeason(CultureSeason.valueOf(request.getCultureSeason()));
        entity.setMonth(request.getMonth());
        entity.setDay(request.getDay());
        entity.setDurationDays(request.getDurationDays());
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setIsNationalHoliday(request.getIsNationalHoliday());
        entity.setIsPublicHoliday(request.getIsPublicHoliday());
        entity.setSignificance(request.getSignificance());
        entity.setRituals(request.getRituals());
        entity.setModernCelebrations(request.getModernCelebrations());
        entity.setEthnicGroupsInvolved(request.getEthnicGroupsInvolved());
        entity.setProvince(request.getProvince());
        entity.setDistrict(request.getDistrict());
        entity.setIsPopular(request.getIsPopular());
        entity.setIsFeatured(request.getIsFeatured());
        return FestivalMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "festivals", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Festival not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

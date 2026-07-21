package com.knownepal.culture.service.impl;

import com.knownepal.culture.dto.request.EthnicGroupRequest;
import com.knownepal.culture.dto.response.EthnicGroupResponse;
import com.knownepal.culture.exception.ResourceNotFoundException;
import com.knownepal.culture.mapper.EthnicGroupMapper;
import com.knownepal.culture.model.EthnicGroup;
import com.knownepal.culture.model.Language;
import com.knownepal.culture.model.RegionType;
import com.knownepal.culture.repository.EthnicGroupRepository;
import com.knownepal.culture.repository.LanguageRepository;
import com.knownepal.culture.service.EthnicGroupService;
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
public class EthnicGroupServiceImpl implements EthnicGroupService {

    private final EthnicGroupRepository repository;
    private final LanguageRepository languageRepository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "ethnicGroups", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<EthnicGroupResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<EthnicGroup>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(EthnicGroupMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<EthnicGroup>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<EthnicGroupResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(EthnicGroupMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "ethnicGroups", key = "'id:' + #id")
    public EthnicGroupResponse findById(Long id) {
        EthnicGroup entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ethnic group not found with id: " + id));
        return EthnicGroupMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "ethnicGroups", key = "'slug:' + #slug")
    public EthnicGroupResponse findBySlug(String slug) {
        EthnicGroup entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Ethnic group not found with slug: " + slug));
        return EthnicGroupMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "ethnicGroups", allEntries = true)
    public EthnicGroupResponse create(EthnicGroupRequest request) {
        EthnicGroup entity = new EthnicGroup();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPopulationEstimate(request.getPopulationEstimate());
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setProvince(request.getProvince());
        entity.setSubRegion(request.getSubRegion());
        entity.setTraditionalOccupation(request.getTraditionalOccupation());
        entity.setSocialStructure(request.getSocialStructure());
        entity.setReligion(request.getReligion());
        entity.setCustoms(request.getCustoms());
        entity.setRituals(request.getRituals());
        entity.setFestivals(request.getFestivals());
        entity.setIsIndigenous(request.getIsIndigenous());
        entity.setIsDeprived(request.getIsDeprived());
        entity.setOrigin(request.getOrigin());
        entity.setMigrationHistory(request.getMigrationHistory());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        if (request.getLanguageId() != null) {
            Language language = languageRepository.findById(request.getLanguageId())
                    .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + request.getLanguageId()));
            entity.setLanguage(language);
        }
        return EthnicGroupMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "ethnicGroups", allEntries = true)
    public EthnicGroupResponse update(Long id, EthnicGroupRequest request) {
        EthnicGroup entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ethnic group not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setPopulationEstimate(request.getPopulationEstimate());
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setProvince(request.getProvince());
        entity.setSubRegion(request.getSubRegion());
        entity.setTraditionalOccupation(request.getTraditionalOccupation());
        entity.setSocialStructure(request.getSocialStructure());
        entity.setReligion(request.getReligion());
        entity.setCustoms(request.getCustoms());
        entity.setRituals(request.getRituals());
        entity.setFestivals(request.getFestivals());
        entity.setIsIndigenous(request.getIsIndigenous());
        entity.setIsDeprived(request.getIsDeprived());
        entity.setOrigin(request.getOrigin());
        entity.setMigrationHistory(request.getMigrationHistory());
        if (request.getLanguageId() != null) {
            Language language = languageRepository.findById(request.getLanguageId())
                    .orElseThrow(() -> new ResourceNotFoundException("Language not found with id: " + request.getLanguageId()));
            entity.setLanguage(language);
        } else {
            entity.setLanguage(null);
        }
        return EthnicGroupMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "ethnicGroups", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ethnic group not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

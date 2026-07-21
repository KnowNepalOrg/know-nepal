package com.knownepal.culture.service.impl;

import com.knownepal.culture.dto.request.ArtFormRequest;
import com.knownepal.culture.dto.response.ArtFormResponse;
import com.knownepal.culture.exception.ResourceNotFoundException;
import com.knownepal.culture.mapper.ArtFormMapper;
import com.knownepal.culture.model.ArtForm;
import com.knownepal.culture.model.ArtType;
import com.knownepal.culture.model.EthnicGroup;
import com.knownepal.culture.model.RegionType;
import com.knownepal.culture.repository.ArtFormRepository;
import com.knownepal.culture.repository.EthnicGroupRepository;
import com.knownepal.culture.service.ArtFormService;
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
public class ArtFormServiceImpl implements ArtFormService {

    private final ArtFormRepository repository;
    private final EthnicGroupRepository ethnicGroupRepository;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "artForms", key = "'all:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public List<ArtFormResponse> findAll(Pageable pageable, Map<String, String> filters) {
        var spec = (Specification<ArtForm>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.findAll(spec, pageable).stream()
                .map(ArtFormMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public long count(Map<String, String> filters) {
        var spec = (Specification<ArtForm>) (Specification<?>) SpecificationFactory.buildSpec(filters);
        return repository.count(spec);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ArtFormResponse> search(String query, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(query).stream()
                .skip((long) pageable.getPageNumber() * pageable.getPageSize())
                .limit(pageable.getPageSize())
                .map(ArtFormMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "artForms", key = "'id:' + #id")
    public ArtFormResponse findById(Long id) {
        ArtForm entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Art form not found with id: " + id));
        return ArtFormMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "artForms", key = "'slug:' + #slug")
    public ArtFormResponse findBySlug(String slug) {
        ArtForm entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Art form not found with slug: " + slug));
        return ArtFormMapper.toResponse(entity);
    }

    @Override
    @Transactional
    @CacheEvict(value = "artForms", allEntries = true)
    public ArtFormResponse create(ArtFormRequest request) {
        ArtForm entity = new ArtForm();
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setArtType(ArtType.valueOf(request.getArtType()));
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setProvince(request.getProvince());
        entity.setHistoricalSignificance(request.getHistoricalSignificance());
        entity.setTechniques(request.getTechniques());
        entity.setMaterials(request.getMaterials());
        entity.setSignificance(request.getSignificance());
        entity.setContemporaryRelevance(request.getContemporaryRelevance());
        entity.setIsIntangibleHeritage(request.getIsIntangibleHeritage());
        entity.setSlug(SlugUtil.generateUnique(request.getName(), repository::existsBySlug));
        if (request.getEthnicGroupId() != null) {
            EthnicGroup ethnicGroup = ethnicGroupRepository.findById(request.getEthnicGroupId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ethnic group not found with id: " + request.getEthnicGroupId()));
            entity.setEthnicGroup(ethnicGroup);
        }
        return ArtFormMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "artForms", allEntries = true)
    public ArtFormResponse update(Long id, ArtFormRequest request) {
        ArtForm entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Art form not found with id: " + id));
        entity.setName(request.getName());
        entity.setDescription(request.getDescription());
        entity.setArtType(ArtType.valueOf(request.getArtType()));
        entity.setRegionType(request.getRegionType() != null ? RegionType.valueOf(request.getRegionType()) : null);
        entity.setProvince(request.getProvince());
        entity.setHistoricalSignificance(request.getHistoricalSignificance());
        entity.setTechniques(request.getTechniques());
        entity.setMaterials(request.getMaterials());
        entity.setSignificance(request.getSignificance());
        entity.setContemporaryRelevance(request.getContemporaryRelevance());
        entity.setIsIntangibleHeritage(request.getIsIntangibleHeritage());
        if (request.getEthnicGroupId() != null) {
            EthnicGroup ethnicGroup = ethnicGroupRepository.findById(request.getEthnicGroupId())
                    .orElseThrow(() -> new ResourceNotFoundException("Ethnic group not found with id: " + request.getEthnicGroupId()));
            entity.setEthnicGroup(ethnicGroup);
        } else {
            entity.setEthnicGroup(null);
        }
        return ArtFormMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    @CacheEvict(value = "artForms", allEntries = true)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Art form not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

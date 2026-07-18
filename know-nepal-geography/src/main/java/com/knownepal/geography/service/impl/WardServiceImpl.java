package com.knownepal.geography.service.impl;

import com.knownepal.geography.dto.request.WardRequest;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.WardResponse;
import com.knownepal.geography.exception.ConflictException;
import com.knownepal.geography.exception.ResourceNotFoundException;
import com.knownepal.geography.mapper.WardMapper;
import com.knownepal.geography.model.Municipality;
import com.knownepal.geography.model.Ward;
import com.knownepal.geography.repository.MunicipalityRepository;
import com.knownepal.geography.repository.WardRepository;
import com.knownepal.geography.service.WardService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class WardServiceImpl implements WardService {

    private final WardRepository wardRepository;
    private final MunicipalityRepository municipalityRepository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "wards", key = "'all:' + (#spec != null ? #spec.toString() : 'none') + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<WardResponse> findAll(Specification<Ward> spec, Pageable pageable) {
        Page<Ward> page = wardRepository.findAll(spec, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "wards", key = "'id:' + #id")
    public WardResponse findById(Long id) {
        Ward ward = wardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ward not found with id: " + id));
        return WardMapper.toResponse(ward);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "wards", key = "'slug:' + #slug")
    public WardResponse findBySlug(String slug) {
        Ward ward = wardRepository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Ward not found with slug: " + slug));
        return WardMapper.toResponse(ward);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "wards", key = "'municipalityId:' + #municipalityId + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<WardResponse> findByMunicipalityId(Long municipalityId, Pageable pageable) {
        Page<Ward> page = wardRepository.findByMunicipalityIdOrderByNumberAsc(municipalityId, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "wards", key = "'municipalitySlug:' + #municipalitySlug + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<WardResponse> findByMunicipalitySlug(String municipalitySlug, Pageable pageable) {
        Page<Ward> page = wardRepository.findByMunicipalitySlug(municipalitySlug, pageable);
        return toPagedResponse(page);
    }

    @Override
    public WardResponse create(WardRequest request) {
        if (wardRepository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Ward already exists with slug: " + request.getSlug());
        }
        if (wardRepository.existsByMunicipalityIdAndNumber(request.getMunicipalityId(), request.getNumber())) {
            throw new ConflictException("Ward number " + request.getNumber()
                    + " already exists in municipality id: " + request.getMunicipalityId());
        }
        Municipality municipality = municipalityRepository.findById(request.getMunicipalityId())
                .orElseThrow(() -> new ResourceNotFoundException(
                        "Municipality not found with id: " + request.getMunicipalityId()));

        Ward ward = WardMapper.toEntity(request);
        ward.setMunicipality(municipality);
        Ward saved = wardRepository.save(ward);
        return WardMapper.toResponse(saved);
    }

    @Override
    public WardResponse update(Long id, WardRequest request) {
        Ward ward = wardRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ward not found with id: " + id));

        if (request.getMunicipalityId() != null) {
            Municipality municipality = municipalityRepository.findById(request.getMunicipalityId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Municipality not found with id: " + request.getMunicipalityId()));
            ward.setMunicipality(municipality);
        }

        WardMapper.updateEntity(ward, request);
        Ward updated = wardRepository.save(ward);
        return WardMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!wardRepository.existsById(id)) {
            throw new ResourceNotFoundException("Ward not found with id: " + id);
        }
        wardRepository.deleteById(id);
    }

    private PagedResponse<WardResponse> toPagedResponse(Page<Ward> page) {
        return new PagedResponse<>(
                page.getContent().stream().map(WardMapper::toResponse).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
    }
}

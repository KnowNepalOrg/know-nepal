package com.knownepal.geography.service.impl;

import com.knownepal.geography.dto.request.MunicipalityRequest;
import com.knownepal.geography.dto.response.MunicipalityResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.WardResponse;
import com.knownepal.geography.exception.ConflictException;
import com.knownepal.geography.exception.ResourceNotFoundException;
import com.knownepal.geography.mapper.MunicipalityMapper;
import com.knownepal.geography.mapper.WardMapper;
import com.knownepal.geography.model.District;
import com.knownepal.geography.model.Municipality;
import com.knownepal.geography.model.MunicipalityType;
import com.knownepal.geography.model.Ward;
import com.knownepal.geography.repository.DistrictRepository;
import com.knownepal.geography.repository.MunicipalityRepository;
import com.knownepal.geography.repository.WardRepository;
import com.knownepal.geography.service.MunicipalityService;
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
public class MunicipalityServiceImpl implements MunicipalityService {

    private final MunicipalityRepository municipalityRepository;
    private final DistrictRepository districtRepository;
    private final WardRepository wardRepository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "municipalities", key = "'all:' + (#spec != null ? #spec.toString() : 'none') + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<MunicipalityResponse> findAll(Specification<Municipality> spec, Pageable pageable) {
        Page<Municipality> page = municipalityRepository.findAll(spec, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "municipalities", key = "'id:' + #id")
    public MunicipalityResponse findById(Long id) {
        Municipality municipality = municipalityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Municipality not found with id: " + id));
        return MunicipalityMapper.toResponse(municipality);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "municipalities", key = "'slug:' + #slug")
    public MunicipalityResponse findBySlug(String slug) {
        Municipality municipality = municipalityRepository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Municipality not found with slug: " + slug));
        return MunicipalityMapper.toResponse(municipality);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "municipalities", key = "'code:' + #code")
    public MunicipalityResponse findByCode(String code) {
        Municipality municipality = municipalityRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Municipality not found with code: " + code));
        return MunicipalityMapper.toResponse(municipality);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "municipalities", key = "'districtId:' + #districtId + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<MunicipalityResponse> findByDistrictId(Long districtId, Pageable pageable) {
        Page<Municipality> page = municipalityRepository.findByDistrictId(districtId, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "municipalities", key = "'districtSlug:' + #districtSlug + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<MunicipalityResponse> findByDistrictSlug(String districtSlug, Pageable pageable) {
        Page<Municipality> page = municipalityRepository.findByDistrictSlug(districtSlug, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "municipalities", key = "'type:' + #type + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<MunicipalityResponse> findByType(MunicipalityType type, Pageable pageable) {
        Page<Municipality> page = municipalityRepository.findByType(type, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    public PagedResponse<WardResponse> findWardsBySlug(String municipalitySlug, Pageable pageable) {
        municipalityRepository.findBySlug(municipalitySlug)
                .orElseThrow(() -> new ResourceNotFoundException("Municipality not found with slug: " + municipalitySlug));
        Page<Ward> page = wardRepository.findByMunicipalitySlug(municipalitySlug, pageable);
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

    @Override
    public MunicipalityResponse create(MunicipalityRequest request) {
        if (municipalityRepository.existsByNameIgnoreCase(request.getName())) {
            throw new ConflictException("Municipality already exists with name: " + request.getName());
        }
        if (municipalityRepository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("Municipality already exists with code: " + request.getCode());
        }
        if (municipalityRepository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Municipality already exists with slug: " + request.getSlug());
        }
        District district = districtRepository.findById(request.getDistrictId())
                .orElseThrow(() -> new ResourceNotFoundException("District not found with id: " + request.getDistrictId()));

        Municipality municipality = MunicipalityMapper.toEntity(request);
        municipality.setDistrict(district);
        Municipality saved = municipalityRepository.save(municipality);
        return MunicipalityMapper.toResponse(saved);
    }

    @Override
    public MunicipalityResponse update(Long id, MunicipalityRequest request) {
        Municipality municipality = municipalityRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Municipality not found with id: " + id));

        if (request.getDistrictId() != null) {
            District district = districtRepository.findById(request.getDistrictId())
                    .orElseThrow(() -> new ResourceNotFoundException("District not found with id: " + request.getDistrictId()));
            municipality.setDistrict(district);
        }

        MunicipalityMapper.updateEntity(municipality, request);
        Municipality updated = municipalityRepository.save(municipality);
        return MunicipalityMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!municipalityRepository.existsById(id)) {
            throw new ResourceNotFoundException("Municipality not found with id: " + id);
        }
        municipalityRepository.deleteById(id);
    }

    private PagedResponse<MunicipalityResponse> toPagedResponse(Page<Municipality> page) {
        return new PagedResponse<>(
                page.getContent().stream().map(MunicipalityMapper::toResponse).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
    }
}

package com.knownepal.geography.service.impl;

import com.knownepal.geography.dto.request.DistrictRequest;
import com.knownepal.geography.dto.response.DistrictResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.exception.ConflictException;
import com.knownepal.geography.exception.ResourceNotFoundException;
import com.knownepal.geography.mapper.DistrictMapper;
import com.knownepal.geography.model.District;
import com.knownepal.geography.model.Province;
import com.knownepal.geography.repository.DistrictRepository;
import com.knownepal.geography.repository.ProvinceRepository;
import com.knownepal.geography.service.DistrictService;
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
public class DistrictServiceImpl implements DistrictService {

    private final DistrictRepository districtRepository;
    private final ProvinceRepository provinceRepository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "districts", key = "'all:' + (#spec != null ? #spec.toString() : 'none') + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<DistrictResponse> findAll(Specification<District> spec, Pageable pageable) {
        Page<District> page = districtRepository.findAll(spec, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "districts", key = "'id:' + #id")
    public DistrictResponse findById(Long id) {
        District district = districtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("District not found with id: " + id));
        return DistrictMapper.toResponse(district);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "districts", key = "'slug:' + #slug")
    public DistrictResponse findBySlug(String slug) {
        District district = districtRepository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("District not found with slug: " + slug));
        return DistrictMapper.toResponse(district);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "districts", key = "'code:' + #code")
    public DistrictResponse findByCode(String code) {
        District district = districtRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("District not found with code: " + code));
        return DistrictMapper.toResponse(district);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "districts", key = "'provinceId:' + #provinceId + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<DistrictResponse> findByProvinceId(Long provinceId, Pageable pageable) {
        Page<District> page = districtRepository.findByProvinceId(provinceId, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "districts", key = "'provinceSlug:' + #provinceSlug + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<DistrictResponse> findByProvinceSlug(String provinceSlug, Pageable pageable) {
        Page<District> page = districtRepository.findByProvinceSlug(provinceSlug, pageable);
        return toPagedResponse(page);
    }

    @Override
    public DistrictResponse create(DistrictRequest request) {
        if (districtRepository.existsByNameIgnoreCase(request.getName())) {
            throw new ConflictException("District already exists with name: " + request.getName());
        }
        if (districtRepository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("District already exists with code: " + request.getCode());
        }
        if (districtRepository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("District already exists with slug: " + request.getSlug());
        }
        Province province = provinceRepository.findById(request.getProvinceId())
                .orElseThrow(() -> new ResourceNotFoundException("Province not found with id: " + request.getProvinceId()));

        District district = DistrictMapper.toEntity(request);
        district.setProvince(province);
        District saved = districtRepository.save(district);
        return DistrictMapper.toResponse(saved);
    }

    @Override
    public DistrictResponse update(Long id, DistrictRequest request) {
        District district = districtRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("District not found with id: " + id));

        if (request.getProvinceId() != null) {
            Province province = provinceRepository.findById(request.getProvinceId())
                    .orElseThrow(() -> new ResourceNotFoundException("Province not found with id: " + request.getProvinceId()));
            district.setProvince(province);
        }

        DistrictMapper.updateEntity(district, request);
        District updated = districtRepository.save(district);
        return DistrictMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!districtRepository.existsById(id)) {
            throw new ResourceNotFoundException("District not found with id: " + id);
        }
        districtRepository.deleteById(id);
    }

    private PagedResponse<DistrictResponse> toPagedResponse(Page<District> page) {
        return new PagedResponse<>(
                page.getContent().stream().map(DistrictMapper::toResponse).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
    }
}

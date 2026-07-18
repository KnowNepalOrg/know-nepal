package com.knownepal.geography.service.impl;

import com.knownepal.geography.dto.request.ProvinceRequest;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.dto.response.ProvinceResponse;
import com.knownepal.geography.exception.ConflictException;
import com.knownepal.geography.exception.ResourceNotFoundException;
import com.knownepal.geography.mapper.ProvinceMapper;
import com.knownepal.geography.model.Province;
import com.knownepal.geography.repository.ProvinceRepository;
import com.knownepal.geography.service.ProvinceService;
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
public class ProvinceServiceImpl implements ProvinceService {

    private final ProvinceRepository provinceRepository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "provinces", key = "'all:' + (#spec != null ? #spec.toString() : 'none') + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<ProvinceResponse> findAll(Specification<Province> spec, Pageable pageable) {
        Page<Province> page = provinceRepository.findAll(spec, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "provinces", key = "'id:' + #id")
    public ProvinceResponse findById(Long id) {
        Province province = provinceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Province not found with id: " + id));
        return ProvinceMapper.toResponse(province);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "provinces", key = "'slug:' + #slug")
    public ProvinceResponse findBySlug(String slug) {
        Province province = provinceRepository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Province not found with slug: " + slug));
        return ProvinceMapper.toResponse(province);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "provinces", key = "'code:' + #code")
    public ProvinceResponse findByCode(String code) {
        Province province = provinceRepository.findByCode(code)
                .orElseThrow(() -> new ResourceNotFoundException("Province not found with code: " + code));
        return ProvinceMapper.toResponse(province);
    }

    @Override
    public ProvinceResponse create(ProvinceRequest request) {
        if (provinceRepository.existsByNameIgnoreCase(request.getName())) {
            throw new ConflictException("Province already exists with name: " + request.getName());
        }
        if (provinceRepository.existsByCodeIgnoreCase(request.getCode())) {
            throw new ConflictException("Province already exists with code: " + request.getCode());
        }
        if (provinceRepository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Province already exists with slug: " + request.getSlug());
        }
        Province province = ProvinceMapper.toEntity(request);
        Province saved = provinceRepository.save(province);
        return ProvinceMapper.toResponse(saved);
    }

    @Override
    public ProvinceResponse update(Long id, ProvinceRequest request) {
        Province province = provinceRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Province not found with id: " + id));
        ProvinceMapper.updateEntity(province, request);
        Province updated = provinceRepository.save(province);
        return ProvinceMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!provinceRepository.existsById(id)) {
            throw new ResourceNotFoundException("Province not found with id: " + id);
        }
        provinceRepository.deleteById(id);
    }

    private PagedResponse<ProvinceResponse> toPagedResponse(Page<Province> page) {
        return new PagedResponse<>(
                page.getContent().stream().map(ProvinceMapper::toResponse).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
    }
}

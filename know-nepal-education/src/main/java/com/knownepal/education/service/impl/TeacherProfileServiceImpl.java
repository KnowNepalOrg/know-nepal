package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.TeacherProfileRequest;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.dto.response.TeacherProfileResponse;
import com.knownepal.education.exception.ConflictException;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.TeacherProfileMapper;
import com.knownepal.education.model.QualificationLevel;
import com.knownepal.education.model.TeacherProfile;
import com.knownepal.education.repository.TeacherProfileRepository;
import com.knownepal.education.service.TeacherProfileService;
import com.knownepal.education.specification.TeacherProfileSpecification;
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
public class TeacherProfileServiceImpl implements TeacherProfileService {

    private final TeacherProfileRepository repository;

    @Override
    @Cacheable(value = "teacherProfiles", key = "'slug-' + #slug")
    public TeacherProfileResponse getBySlug(String slug) {
        TeacherProfile teacherProfile = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher profile not found with slug: " + slug));
        return TeacherProfileMapper.toResponse(teacherProfile);
    }

    @Override
    @Cacheable(value = "teacherProfiles", key = "'list-' + #name + '-' + #level + '-' + #institutionType + '-' + #provinceId + '-' + #page + '-' + #size")
    public PagedResponse<TeacherProfileResponse> getAll(String name, QualificationLevel level,
                                                        String institutionType, Long provinceId,
                                                        int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<TeacherProfile> spec = TeacherProfileSpecification.build(name, level, institutionType, provinceId);
        Page<TeacherProfile> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(TeacherProfileMapper::toResponse).toList(),
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
    @CacheEvict(value = "teacherProfiles", allEntries = true)
    public TeacherProfileResponse create(TeacherProfileRequest request) {
        if (repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Teacher profile already exists with slug: " + request.getSlug());
        }

        TeacherProfile teacherProfile = TeacherProfileMapper.toEntity(request);
        TeacherProfile saved = repository.save(teacherProfile);
        return TeacherProfileMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "teacherProfiles", key = "'slug-' + #slug")
    public TeacherProfileResponse update(String slug, TeacherProfileRequest request) {
        TeacherProfile teacherProfile = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher profile not found with slug: " + slug));

        if (!slug.equals(request.getSlug()) && repository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Teacher profile already exists with slug: " + request.getSlug());
        }

        TeacherProfileMapper.updateEntity(teacherProfile, request);
        TeacherProfile saved = repository.save(teacherProfile);
        return TeacherProfileMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "teacherProfiles", allEntries = true)
    public void delete(String slug) {
        TeacherProfile teacherProfile = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Teacher profile not found with slug: " + slug));
        repository.delete(teacherProfile);
    }
}

package com.knownepal.education.service.impl;

import com.knownepal.education.dto.request.AcademicCalendarRequest;
import com.knownepal.education.dto.response.AcademicCalendarResponse;
import com.knownepal.education.dto.response.PagedResponse;
import com.knownepal.education.exception.ResourceNotFoundException;
import com.knownepal.education.mapper.AcademicCalendarMapper;
import com.knownepal.education.model.AcademicCalendar;
import com.knownepal.education.repository.AcademicCalendarRepository;
import com.knownepal.education.service.AcademicCalendarService;
import com.knownepal.education.specification.AcademicCalendarSpecification;
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
public class AcademicCalendarServiceImpl implements AcademicCalendarService {

    private final AcademicCalendarRepository repository;

    @Override
    @Cacheable(value = "academicCalendars", key = "'list-' + #institutionId + '-' + #institutionType + '-' + #academicYear + '-' + #page + '-' + #size")
    public PagedResponse<AcademicCalendarResponse> getAll(Long institutionId, String institutionType,
                                                          String academicYear, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<AcademicCalendar> spec = AcademicCalendarSpecification.build(institutionType, institutionId, academicYear);
        Page<AcademicCalendar> pageResult = repository.findAll(spec, pageable);

        return new PagedResponse<>(
                pageResult.getContent().stream().map(AcademicCalendarMapper::toResponse).toList(),
                pageResult.getNumber(),
                pageResult.getSize(),
                pageResult.getTotalElements(),
                pageResult.getTotalPages(),
                pageResult.isFirst(),
                pageResult.isLast()
        );
    }

    @Override
    @Cacheable(value = "academicCalendars", key = "'id-' + #id")
    public AcademicCalendarResponse getById(Long id) {
        AcademicCalendar academicCalendar = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Academic calendar not found with id: " + id));
        return AcademicCalendarMapper.toResponse(academicCalendar);
    }

    @Override
    @Transactional
    @CacheEvict(value = "academicCalendars", allEntries = true)
    public AcademicCalendarResponse create(AcademicCalendarRequest request) {
        AcademicCalendar academicCalendar = AcademicCalendarMapper.toEntity(request);
        AcademicCalendar saved = repository.save(academicCalendar);
        return AcademicCalendarMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CachePut(value = "academicCalendars", key = "'id-' + #id")
    public AcademicCalendarResponse update(Long id, AcademicCalendarRequest request) {
        AcademicCalendar academicCalendar = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Academic calendar not found with id: " + id));

        AcademicCalendarMapper.updateEntity(academicCalendar, request);
        AcademicCalendar saved = repository.save(academicCalendar);
        return AcademicCalendarMapper.toResponse(saved);
    }

    @Override
    @Transactional
    @CacheEvict(value = "academicCalendars", allEntries = true)
    public void delete(Long id) {
        AcademicCalendar academicCalendar = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Academic calendar not found with id: " + id));
        repository.delete(academicCalendar);
    }
}

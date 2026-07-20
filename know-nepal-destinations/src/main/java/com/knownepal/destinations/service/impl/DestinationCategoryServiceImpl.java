package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.DestinationCategoryRequest;
import com.knownepal.destinations.dto.response.DestinationCategoryResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.DestinationCategoryMapper;
import com.knownepal.destinations.model.DestinationCategory;
import com.knownepal.destinations.repository.DestinationCategoryRepository;
import com.knownepal.destinations.service.DestinationCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationCategoryServiceImpl implements DestinationCategoryService {

    private final DestinationCategoryRepository repository;

    @Override
    public List<DestinationCategoryResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream()
                .map(DestinationCategoryMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DestinationCategoryResponse findById(Long id) {
        DestinationCategory entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        return DestinationCategoryMapper.toResponse(entity);
    }

    @Override
    public DestinationCategoryResponse findBySlug(String slug) {
        DestinationCategory entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with slug: " + slug));
        return DestinationCategoryMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public DestinationCategoryResponse create(DestinationCategoryRequest request) {
        DestinationCategory entity = DestinationCategoryMapper.toEntity(request);
        entity.setSlug(generateSlug(request.getName()));
        return DestinationCategoryMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public DestinationCategoryResponse update(Long id, DestinationCategoryRequest request) {
        DestinationCategory entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
        DestinationCategoryMapper.updateEntity(entity, request);
        return DestinationCategoryMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Category not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public long count() {
        return repository.count();
    }

    private String generateSlug(String name) {
        String slug = name.toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "");
        String baseSlug = slug;
        int counter = 1;
        while (repository.existsBySlug(slug)) {
            slug = baseSlug + "-" + counter++;
        }
        return slug;
    }
}

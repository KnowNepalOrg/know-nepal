package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.DestinationTagRequest;
import com.knownepal.destinations.dto.response.TagResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.DestinationTagMapper;
import com.knownepal.destinations.model.DestinationTag;
import com.knownepal.destinations.repository.DestinationTagRepository;
import com.knownepal.destinations.service.DestinationTagService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationTagServiceImpl implements DestinationTagService {

    private final DestinationTagRepository repository;

    @Override
    public List<TagResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream()
                .map(DestinationTagMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public TagResponse findById(Long id) {
        DestinationTag entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with id: " + id));
        return DestinationTagMapper.toResponse(entity);
    }

    @Override
    public TagResponse findBySlug(String slug) {
        DestinationTag entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with slug: " + slug));
        return DestinationTagMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public TagResponse create(DestinationTagRequest request) {
        DestinationTag entity = DestinationTagMapper.toEntity(request);
        entity.setSlug(generateSlug(request.getName()));
        return DestinationTagMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public TagResponse update(Long id, DestinationTagRequest request) {
        DestinationTag entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Tag not found with id: " + id));
        DestinationTagMapper.updateEntity(entity, request);
        return DestinationTagMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Tag not found with id: " + id);
        }
        repository.deleteById(id);
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

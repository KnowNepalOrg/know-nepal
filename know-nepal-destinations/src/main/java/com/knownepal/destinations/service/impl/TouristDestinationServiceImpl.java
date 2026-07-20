package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.TouristDestinationRequest;
import com.knownepal.destinations.dto.response.TouristDestinationResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.TouristDestinationMapper;
import com.knownepal.destinations.model.DestinationCategory;
import com.knownepal.destinations.model.DestinationTag;
import com.knownepal.destinations.model.TouristDestination;
import com.knownepal.destinations.repository.DestinationCategoryRepository;
import com.knownepal.destinations.repository.DestinationTagRepository;
import com.knownepal.destinations.repository.TouristDestinationRepository;
import com.knownepal.destinations.service.TouristDestinationService;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TouristDestinationServiceImpl implements TouristDestinationService {

    private final TouristDestinationRepository repository;
    private final DestinationCategoryRepository categoryRepository;
    private final DestinationTagRepository tagRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TouristDestinationResponse> findAll(Pageable pageable) {
        return repository.findAll(pageable).stream()
                .map(TouristDestinationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public TouristDestinationResponse findById(Long id) {
        TouristDestination entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + id));
        return TouristDestinationMapper.toResponse(entity);
    }

    @Override
    @Transactional(readOnly = true)
    public TouristDestinationResponse findBySlug(String slug) {
        TouristDestination entity = repository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with slug: " + slug));
        return TouristDestinationMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public TouristDestinationResponse create(TouristDestinationRequest request) {
        TouristDestination entity = TouristDestinationMapper.toEntity(request);
        entity.setSlug(generateSlug(request.getName()));
        if (request.getCategoryId() != null) {
            DestinationCategory category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + request.getCategoryId()));
            entity.setCategory(category);
        }
        if (request.getTagIds() != null && !request.getTagIds().isEmpty()) {
            List<DestinationTag> tags = tagRepository.findAllById(request.getTagIds());
            entity.setTags(tags);
        }
        return TouristDestinationMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public TouristDestinationResponse update(Long id, TouristDestinationRequest request) {
        TouristDestination entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + id));
        TouristDestinationMapper.updateEntity(entity, request);
        if (request.getCategoryId() != null) {
            DestinationCategory category = categoryRepository.findById(request.getCategoryId())
                    .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + request.getCategoryId()));
            entity.setCategory(category);
        }
        if (request.getTagIds() != null) {
            List<DestinationTag> tags = tagRepository.findAllById(request.getTagIds());
            entity.setTags(tags);
        }
        return TouristDestinationMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Destination not found with id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TouristDestinationResponse> search(String query, Pageable pageable) {
        Specification<TouristDestination> spec = (root, cq, cb) -> {
            String pattern = "%" + query.toLowerCase() + "%";
            Predicate namePredicate = cb.like(cb.lower(root.get("name")), pattern);
            Predicate descPredicate = cb.like(cb.lower(root.get("description")), pattern);
            return cb.or(namePredicate, descPredicate);
        };
        return repository.findAll(spec, pageable).stream()
                .map(TouristDestinationMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<TouristDestinationResponse> findByFilters(Map<String, String> filters, Pageable pageable) {
        Specification<TouristDestination> spec = (root, cq, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (filters.containsKey("destinationType")) {
                predicates.add(cb.equal(root.get("destinationType"), filters.get("destinationType")));
            }
            if (filters.containsKey("bestSeason")) {
                predicates.add(cb.equal(root.get("bestSeason"), filters.get("bestSeason")));
            }
            if (filters.containsKey("difficultyLevel")) {
                predicates.add(cb.equal(root.get("difficultyLevel"), filters.get("difficultyLevel")));
            }
            if (filters.containsKey("provinceId")) {
                predicates.add(cb.equal(root.get("provinceId"), Long.parseLong(filters.get("provinceId"))));
            }
            if (filters.containsKey("isPopular")) {
                predicates.add(cb.equal(root.get("isPopular"), Boolean.parseBoolean(filters.get("isPopular"))));
            }
            if (filters.containsKey("isFeatured")) {
                predicates.add(cb.equal(root.get("isFeatured"), Boolean.parseBoolean(filters.get("isFeatured"))));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
        return repository.findAll(spec, pageable).stream()
                .map(TouristDestinationMapper::toResponse)
                .collect(Collectors.toList());
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

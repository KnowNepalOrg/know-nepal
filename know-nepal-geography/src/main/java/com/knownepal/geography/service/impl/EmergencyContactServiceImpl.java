package com.knownepal.geography.service.impl;

import com.knownepal.geography.dto.request.EmergencyContactRequest;
import com.knownepal.geography.dto.response.EmergencyContactResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.exception.ConflictException;
import com.knownepal.geography.exception.ResourceNotFoundException;
import com.knownepal.geography.mapper.EmergencyContactMapper;
import com.knownepal.geography.model.District;
import com.knownepal.geography.model.EmergencyContact;
import com.knownepal.geography.model.Province;
import com.knownepal.geography.repository.DistrictRepository;
import com.knownepal.geography.repository.EmergencyContactRepository;
import com.knownepal.geography.repository.ProvinceRepository;
import com.knownepal.geography.service.EmergencyContactService;
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
public class EmergencyContactServiceImpl implements EmergencyContactService {

    private final EmergencyContactRepository emergencyContactRepository;
    private final DistrictRepository districtRepository;
    private final ProvinceRepository provinceRepository;

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "emergencyContacts", key = "'all:' + (#spec != null ? #spec.toString() : 'none') + ':' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<EmergencyContactResponse> findAll(Specification<EmergencyContact> spec, Pageable pageable) {
        Page<EmergencyContact> page = emergencyContactRepository.findAll(spec, pageable);
        return toPagedResponse(page);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "emergencyContacts", key = "'id:' + #id")
    public EmergencyContactResponse findById(Long id) {
        EmergencyContact contact = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency contact not found with id: " + id));
        return EmergencyContactMapper.toResponse(contact);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "emergencyContacts", key = "'slug:' + #slug")
    public EmergencyContactResponse findBySlug(String slug) {
        EmergencyContact contact = emergencyContactRepository.findBySlug(slug)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency contact not found with slug: " + slug));
        return EmergencyContactMapper.toResponse(contact);
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(value = "emergencyContacts", key = "'national:' + #pageable.pageNumber + ':' + #pageable.pageSize")
    public PagedResponse<EmergencyContactResponse> findNational(Pageable pageable) {
        Page<EmergencyContact> page = emergencyContactRepository.findByIsNationalTrue(pageable);
        return toPagedResponse(page);
    }

    @Override
    public EmergencyContactResponse create(EmergencyContactRequest request) {
        if (emergencyContactRepository.existsBySlugIgnoreCase(request.getSlug())) {
            throw new ConflictException("Emergency contact already exists with slug: " + request.getSlug());
        }
        EmergencyContact contact = EmergencyContactMapper.toEntity(request);

        if (request.getDistrictId() != null) {
            District district = districtRepository.findById(request.getDistrictId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "District not found with id: " + request.getDistrictId()));
            contact.setDistrict(district);
        }
        if (request.getProvinceId() != null) {
            Province province = provinceRepository.findById(request.getProvinceId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Province not found with id: " + request.getProvinceId()));
            contact.setProvince(province);
        }

        EmergencyContact saved = emergencyContactRepository.save(contact);
        return EmergencyContactMapper.toResponse(saved);
    }

    @Override
    public EmergencyContactResponse update(Long id, EmergencyContactRequest request) {
        EmergencyContact contact = emergencyContactRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Emergency contact not found with id: " + id));

        if (request.getDistrictId() != null) {
            District district = districtRepository.findById(request.getDistrictId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "District not found with id: " + request.getDistrictId()));
            contact.setDistrict(district);
        }
        if (request.getProvinceId() != null) {
            Province province = provinceRepository.findById(request.getProvinceId())
                    .orElseThrow(() -> new ResourceNotFoundException(
                            "Province not found with id: " + request.getProvinceId()));
            contact.setProvince(province);
        }

        EmergencyContactMapper.updateEntity(contact, request);
        EmergencyContact updated = emergencyContactRepository.save(contact);
        return EmergencyContactMapper.toResponse(updated);
    }

    @Override
    public void delete(Long id) {
        if (!emergencyContactRepository.existsById(id)) {
            throw new ResourceNotFoundException("Emergency contact not found with id: " + id);
        }
        emergencyContactRepository.deleteById(id);
    }

    private PagedResponse<EmergencyContactResponse> toPagedResponse(Page<EmergencyContact> page) {
        return new PagedResponse<>(
                page.getContent().stream().map(EmergencyContactMapper::toResponse).toList(),
                page.getNumber(),
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages(),
                page.isFirst(),
                page.isLast()
        );
    }
}

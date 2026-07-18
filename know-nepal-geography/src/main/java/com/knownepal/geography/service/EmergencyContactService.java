package com.knownepal.geography.service;

import com.knownepal.geography.dto.request.EmergencyContactRequest;
import com.knownepal.geography.dto.response.EmergencyContactResponse;
import com.knownepal.geography.dto.response.PagedResponse;
import com.knownepal.geography.model.EmergencyContact;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface EmergencyContactService {

    PagedResponse<EmergencyContactResponse> findAll(Specification<EmergencyContact> spec, Pageable pageable);

    EmergencyContactResponse findById(Long id);

    EmergencyContactResponse findBySlug(String slug);

    PagedResponse<EmergencyContactResponse> findNational(Pageable pageable);

    EmergencyContactResponse create(EmergencyContactRequest request);

    EmergencyContactResponse update(Long id, EmergencyContactRequest request);

    void delete(Long id);
}

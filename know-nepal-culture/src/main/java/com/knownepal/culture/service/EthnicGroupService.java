package com.knownepal.culture.service;

import com.knownepal.culture.dto.request.EthnicGroupRequest;
import com.knownepal.culture.dto.response.EthnicGroupResponse;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface EthnicGroupService {
    List<EthnicGroupResponse> findAll(Pageable pageable, Map<String, String> filters);
    long count(Map<String, String> filters);
    List<EthnicGroupResponse> search(String query, Pageable pageable);
    EthnicGroupResponse findById(Long id);
    EthnicGroupResponse findBySlug(String slug);
    EthnicGroupResponse create(EthnicGroupRequest request);
    EthnicGroupResponse update(Long id, EthnicGroupRequest request);
    void delete(Long id);
}

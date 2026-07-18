package com.knownepal.geography.service.impl;

import com.knownepal.geography.dto.response.SearchResponse;
import com.knownepal.geography.dto.response.SearchResult;
import com.knownepal.geography.repository.*;
import com.knownepal.geography.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SearchServiceImpl implements SearchService {

    private final ProvinceRepository provinceRepository;
    private final DistrictRepository districtRepository;
    private final MunicipalityRepository municipalityRepository;
    private final WardRepository wardRepository;
    private final EmergencyContactRepository emergencyContactRepository;

    @Override
    public SearchResponse search(String query) {
        if (query == null || query.isBlank()) {
            return new SearchResponse(query, List.of(), List.of(), List.of(), List.of(), List.of(), 0);
        }

        String q = query.trim();

        List<SearchResult> provinces = provinceRepository.search(q).stream()
                .map(p -> new SearchResult(
                        p.getId(), p.getName(), p.getNameNepali(), p.getSlug(),
                        "PROVINCE", null, p.getCapital()))
                .collect(Collectors.toList());

        List<SearchResult> districts = districtRepository.search(q).stream()
                .map(d -> new SearchResult(
                        d.getId(), d.getName(), d.getNameNepali(), d.getSlug(),
                        "DISTRICT",
                        d.getProvince() != null ? d.getProvince().getName() : null,
                        d.getHeadquarters()))
                .collect(Collectors.toList());

        List<SearchResult> municipalities = municipalityRepository.search(q).stream()
                .map(m -> new SearchResult(
                        m.getId(), m.getName(), m.getNameNepali(), m.getSlug(),
                        "MUNICIPALITY",
                        m.getDistrict() != null ? m.getDistrict().getName() : null,
                        m.getType() != null ? m.getType().name() : null))
                .collect(Collectors.toList());

        List<SearchResult> wards = wardRepository.search(q).stream()
                .map(w -> new SearchResult(
                        w.getId(), w.getName(), w.getNameNepali(), w.getSlug(),
                        "WARD",
                        w.getMunicipality() != null ? w.getMunicipality().getName() : null,
                        w.getNumber() != null ? "Ward No. " + w.getNumber() : null))
                .collect(Collectors.toList());

        List<SearchResult> emergencyContacts = emergencyContactRepository.search(q).stream()
                .map(e -> new SearchResult(
                        e.getId(), e.getName(), e.getNameNepali(), e.getSlug(),
                        "EMERGENCY_CONTACT",
                        e.getType() != null ? e.getType().name() : null,
                        e.getPhone()))
                .collect(Collectors.toList());

        int totalResults = provinces.size() + districts.size() + municipalities.size()
                + wards.size() + emergencyContacts.size();

        return new SearchResponse(query, provinces, districts, municipalities, wards, emergencyContacts, totalResults);
    }
}

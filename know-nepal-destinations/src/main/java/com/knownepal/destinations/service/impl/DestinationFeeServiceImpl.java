package com.knownepal.destinations.service.impl;

import com.knownepal.destinations.dto.request.DestinationFeeRequest;
import com.knownepal.destinations.dto.response.DestinationFeeResponse;
import com.knownepal.destinations.exception.ResourceNotFoundException;
import com.knownepal.destinations.mapper.DestinationFeeMapper;
import com.knownepal.destinations.model.DestinationFee;
import com.knownepal.destinations.model.TouristDestination;
import com.knownepal.destinations.repository.DestinationFeeRepository;
import com.knownepal.destinations.repository.TouristDestinationRepository;
import com.knownepal.destinations.service.DestinationFeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationFeeServiceImpl implements DestinationFeeService {

    private final DestinationFeeRepository repository;
    private final TouristDestinationRepository destinationRepository;

    @Override
    public List<DestinationFeeResponse> findByDestinationId(Long destinationId) {
        return repository.findByDestinationId(destinationId).stream()
                .map(DestinationFeeMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public DestinationFeeResponse findById(Long id) {
        DestinationFee entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee not found with id: " + id));
        return DestinationFeeMapper.toResponse(entity);
    }

    @Override
    @Transactional
    public DestinationFeeResponse create(Long destinationId, DestinationFeeRequest request) {
        TouristDestination destination = destinationRepository.findById(destinationId)
                .orElseThrow(() -> new ResourceNotFoundException("Destination not found with id: " + destinationId));
        DestinationFee entity = DestinationFee.builder()
                .destination(destination)
                .feeType(request.getFeeType())
                .amount(request.getAmount())
                .currency(request.getCurrency() != null ? request.getCurrency() : "NPR")
                .description(request.getDescription())
                .isMandatory(request.getIsMandatory() != null ? request.getIsMandatory() : false)
                .build();
        return DestinationFeeMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public DestinationFeeResponse update(Long id, DestinationFeeRequest request) {
        DestinationFee entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Fee not found with id: " + id));
        entity.setFeeType(request.getFeeType());
        entity.setAmount(request.getAmount());
        entity.setCurrency(request.getCurrency() != null ? request.getCurrency() : entity.getCurrency());
        entity.setDescription(request.getDescription());
        entity.setIsMandatory(request.getIsMandatory() != null ? request.getIsMandatory() : entity.getIsMandatory());
        return DestinationFeeMapper.toResponse(repository.save(entity));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Fee not found with id: " + id);
        }
        repository.deleteById(id);
    }
}

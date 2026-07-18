package com.knownepal.geography.mapper;

import com.knownepal.geography.dto.request.EmergencyContactRequest;
import com.knownepal.geography.dto.response.EmergencyContactResponse;
import com.knownepal.geography.model.EmergencyContact;

public final class EmergencyContactMapper {

    private EmergencyContactMapper() {
    }

    public static EmergencyContact toEntity(EmergencyContactRequest request) {
        if (request == null) {
            return null;
        }
        return EmergencyContact.builder()
                .name(request.getName())
                .nameNepali(request.getNameNepali())
                .type(request.getType())
                .phone(request.getPhone())
                .alternatePhone(request.getAlternatePhone())
                .email(request.getEmail())
                .website(request.getWebsite())
                .address(request.getAddress())
                .description(request.getDescription())
                .isNational(request.getIsNational() != null ? request.getIsNational() : false)
                .latitude(request.getLatitude())
                .longitude(request.getLongitude())
                .slug(request.getSlug())
                .contactPerson(request.getContactPerson())
                .availableHours(request.getAvailableHours())
                .imageUrl(request.getImageUrl())
                .build();
    }

    public static EmergencyContactResponse toResponse(EmergencyContact contact) {
        if (contact == null) {
            return null;
        }
        return new EmergencyContactResponse(
                contact.getId(),
                contact.getName(),
                contact.getNameNepali(),
                contact.getType(),
                contact.getPhone(),
                contact.getAlternatePhone(),
                contact.getEmail(),
                contact.getWebsite(),
                contact.getAddress(),
                contact.getDescription(),
                contact.getIsNational(),
                contact.getLatitude(),
                contact.getLongitude(),
                contact.getSlug(),
                contact.getContactPerson(),
                contact.getAvailableHours(),
                contact.getImageUrl(),
                contact.getDistrict() != null ? contact.getDistrict().getId() : null,
                contact.getDistrict() != null ? contact.getDistrict().getName() : null,
                contact.getProvince() != null ? contact.getProvince().getId() : null,
                contact.getProvince() != null ? contact.getProvince().getName() : null,
                contact.getCreatedAt(),
                contact.getUpdatedAt()
        );
    }

    public static void updateEntity(EmergencyContact contact, EmergencyContactRequest request) {
        if (request.getName() != null) {
            contact.setName(request.getName());
        }
        if (request.getNameNepali() != null) {
            contact.setNameNepali(request.getNameNepali());
        }
        if (request.getType() != null) {
            contact.setType(request.getType());
        }
        if (request.getPhone() != null) {
            contact.setPhone(request.getPhone());
        }
        if (request.getAlternatePhone() != null) {
            contact.setAlternatePhone(request.getAlternatePhone());
        }
        if (request.getEmail() != null) {
            contact.setEmail(request.getEmail());
        }
        if (request.getWebsite() != null) {
            contact.setWebsite(request.getWebsite());
        }
        if (request.getAddress() != null) {
            contact.setAddress(request.getAddress());
        }
        if (request.getDescription() != null) {
            contact.setDescription(request.getDescription());
        }
        if (request.getIsNational() != null) {
            contact.setIsNational(request.getIsNational());
        }
        if (request.getLatitude() != null) {
            contact.setLatitude(request.getLatitude());
        }
        if (request.getLongitude() != null) {
            contact.setLongitude(request.getLongitude());
        }
        if (request.getSlug() != null) {
            contact.setSlug(request.getSlug());
        }
        if (request.getContactPerson() != null) {
            contact.setContactPerson(request.getContactPerson());
        }
        if (request.getAvailableHours() != null) {
            contact.setAvailableHours(request.getAvailableHours());
        }
        if (request.getImageUrl() != null) {
            contact.setImageUrl(request.getImageUrl());
        }
    }
}

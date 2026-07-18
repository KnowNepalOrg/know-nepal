package com.knownepal.geography.repository;

import com.knownepal.geography.model.EmergencyContact;
import com.knownepal.geography.model.EmergencyContactType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmergencyContactRepository extends JpaRepository<EmergencyContact, Long>,
        JpaSpecificationExecutor<EmergencyContact> {

    Page<EmergencyContact> findByType(EmergencyContactType type, Pageable pageable);

    Page<EmergencyContact> findByIsNationalTrue(Pageable pageable);

    Page<EmergencyContact> findByDistrictId(Long districtId, Pageable pageable);

    Page<EmergencyContact> findByProvinceId(Long provinceId, Pageable pageable);

    Optional<EmergencyContact> findBySlug(String slug);

    Optional<EmergencyContact> findByNameIgnoreCase(String name);

    boolean existsBySlugIgnoreCase(String slug);

    boolean existsByNameIgnoreCase(String name);

    @Query("SELECT e FROM EmergencyContact e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(e.nameNepali) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(e.description) LIKE LOWER(CONCAT('%', :q, '%'))")
    java.util.List<EmergencyContact> search(@Param("q") String query);
}

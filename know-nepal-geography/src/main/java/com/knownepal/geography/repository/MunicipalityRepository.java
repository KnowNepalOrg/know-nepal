package com.knownepal.geography.repository;

import com.knownepal.geography.model.Municipality;
import com.knownepal.geography.model.MunicipalityType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MunicipalityRepository extends JpaRepository<Municipality, Long>, JpaSpecificationExecutor<Municipality> {

    Page<Municipality> findByDistrictId(Long districtId, Pageable pageable);

    Page<Municipality> findByDistrictSlug(String districtSlug, Pageable pageable);

    Page<Municipality> findByDistrictIdAndType(Long districtId, MunicipalityType type, Pageable pageable);

    Page<Municipality> findByType(MunicipalityType type, Pageable pageable);

    Optional<Municipality> findBySlug(String slug);

    Optional<Municipality> findByCode(String code);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    boolean existsBySlugIgnoreCase(String slug);

    @Query("SELECT m FROM Municipality m WHERE LOWER(m.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(m.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    java.util.List<Municipality> search(@Param("q") String query);
}

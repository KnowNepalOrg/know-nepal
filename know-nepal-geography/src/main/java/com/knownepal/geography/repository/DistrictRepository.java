package com.knownepal.geography.repository;

import com.knownepal.geography.model.District;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long>, JpaSpecificationExecutor<District> {

    Page<District> findByProvinceId(Long provinceId, Pageable pageable);

    Page<District> findByProvinceSlug(String provinceSlug, Pageable pageable);

    Optional<District> findBySlug(String slug);

    Optional<District> findByCode(String code);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    boolean existsBySlugIgnoreCase(String slug);

    @Query("SELECT d FROM District d WHERE LOWER(d.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(d.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    java.util.List<District> search(@Param("q") String query);
}

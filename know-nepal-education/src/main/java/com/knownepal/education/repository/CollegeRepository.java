package com.knownepal.education.repository;

import com.knownepal.education.model.College;
import com.knownepal.education.model.CollegeType;
import com.knownepal.education.model.CollegeLevel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CollegeRepository extends JpaRepository<College, Long>, JpaSpecificationExecutor<College> {

    Optional<College> findBySlug(String slug);

    Optional<College> findByCode(String code);

    Page<College> findByType(CollegeType type, Pageable pageable);

    Page<College> findByLevel(CollegeLevel level, Pageable pageable);

    Page<College> findByProvinceId(Long provinceId, Pageable pageable);

    Page<College> findByDistrictId(Long districtId, Pageable pageable);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    boolean existsBySlugIgnoreCase(String slug);

    @Query("SELECT c FROM College c WHERE LOWER(c.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(c.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<College> search(@Param("q") String query);
}

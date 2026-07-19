package com.knownepal.education.repository;

import com.knownepal.education.model.School;
import com.knownepal.education.model.SchoolType;
import com.knownepal.education.model.EducationLevel;
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
public interface SchoolRepository extends JpaRepository<School, Long>, JpaSpecificationExecutor<School> {

    Optional<School> findBySlug(String slug);

    Optional<School> findByCode(String code);

    Page<School> findByType(SchoolType type, Pageable pageable);

    Page<School> findByLevel(EducationLevel level, Pageable pageable);

    Page<School> findByProvinceId(Long provinceId, Pageable pageable);

    Page<School> findByDistrictId(Long districtId, Pageable pageable);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    boolean existsBySlugIgnoreCase(String slug);

    @Query("SELECT s FROM School s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(s.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<School> search(@Param("q") String query);
}

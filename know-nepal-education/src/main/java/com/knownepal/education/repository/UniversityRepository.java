package com.knownepal.education.repository;

import com.knownepal.education.model.University;
import com.knownepal.education.model.UniversityType;
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
public interface UniversityRepository extends JpaRepository<University, Long>, JpaSpecificationExecutor<University> {

    Optional<University> findBySlug(String slug);

    Optional<University> findByCode(String code);

    Page<University> findByType(UniversityType type, Pageable pageable);

    Page<University> findByProvinceId(Long provinceId, Pageable pageable);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    boolean existsBySlugIgnoreCase(String slug);

    @Query("SELECT u FROM University u WHERE LOWER(u.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(u.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<University> search(@Param("q") String query);
}

package com.knownepal.education.repository;

import com.knownepal.education.model.Program;
import com.knownepal.education.model.ProgramLevel;
import com.knownepal.education.model.InstitutionType;
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
public interface ProgramRepository extends JpaRepository<Program, Long>, JpaSpecificationExecutor<Program> {

    Optional<Program> findBySlug(String slug);

    Optional<Program> findByCode(String code);

    Page<Program> findByLevel(ProgramLevel level, Pageable pageable);

    Page<Program> findByFaculty(String faculty, Pageable pageable);

    Page<Program> findByInstitutionTypeAndInstitutionId(InstitutionType institutionType, Long institutionId, Pageable pageable);

    Page<Program> findByInstitutionNameContainingIgnoreCase(String institutionName, Pageable pageable);

    boolean existsByNameIgnoreCase(String name);

    boolean existsByCodeIgnoreCase(String code);

    boolean existsBySlugIgnoreCase(String slug);

    @Query("SELECT p FROM Program p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(p.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<Program> search(@Param("q") String query);
}

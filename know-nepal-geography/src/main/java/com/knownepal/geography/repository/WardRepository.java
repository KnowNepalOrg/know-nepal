package com.knownepal.geography.repository;

import com.knownepal.geography.model.Ward;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WardRepository extends JpaRepository<Ward, Long>, JpaSpecificationExecutor<Ward> {

    Page<Ward> findByMunicipalityIdOrderByNumberAsc(Long municipalityId, Pageable pageable);

    Page<Ward> findByMunicipalitySlug(String municipalitySlug, Pageable pageable);

    Optional<Ward> findBySlug(String slug);

    Optional<Ward> findByMunicipalityIdAndNumber(Long municipalityId, Integer number);

    boolean existsBySlugIgnoreCase(String slug);

    boolean existsByMunicipalityIdAndNumber(Long municipalityId, Integer number);

    @Query("SELECT w FROM Ward w WHERE LOWER(w.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(w.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    java.util.List<Ward> search(@Param("q") String query);
}

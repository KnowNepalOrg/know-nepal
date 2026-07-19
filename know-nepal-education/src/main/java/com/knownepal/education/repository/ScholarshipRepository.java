package com.knownepal.education.repository;

import com.knownepal.education.model.Scholarship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ScholarshipRepository extends JpaRepository<Scholarship, Long>, JpaSpecificationExecutor<Scholarship> {

    Optional<Scholarship> findBySlug(String slug);

    boolean existsBySlugIgnoreCase(String slug);

    @Query("SELECT s FROM Scholarship s WHERE LOWER(s.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(s.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<Scholarship> search(@Param("q") String query);
}

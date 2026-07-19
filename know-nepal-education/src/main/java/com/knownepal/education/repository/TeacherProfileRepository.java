package com.knownepal.education.repository;

import com.knownepal.education.model.TeacherProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TeacherProfileRepository extends JpaRepository<TeacherProfile, Long>, JpaSpecificationExecutor<TeacherProfile> {

    Optional<TeacherProfile> findBySlug(String slug);

    boolean existsBySlugIgnoreCase(String slug);

    @Query("SELECT t FROM TeacherProfile t WHERE LOWER(t.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(t.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<TeacherProfile> search(@Param("q") String query);
}

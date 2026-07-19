package com.knownepal.education.repository;

import com.knownepal.education.model.ExamBoard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExamBoardRepository extends JpaRepository<ExamBoard, Long>, JpaSpecificationExecutor<ExamBoard> {

    Optional<ExamBoard> findBySlug(String slug);

    boolean existsBySlugIgnoreCase(String slug);

    boolean existsByCodeIgnoreCase(String code);

    @Query("SELECT e FROM ExamBoard e WHERE LOWER(e.name) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(e.nameNepali) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<ExamBoard> search(@Param("q") String query);
}

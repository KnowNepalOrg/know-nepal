package com.knownepal.education.repository;

import com.knownepal.education.model.FeeBreakdown;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeeBreakdownRepository extends JpaRepository<FeeBreakdown, Long>, JpaSpecificationExecutor<FeeBreakdown> {

    @Query("SELECT f FROM FeeBreakdown f WHERE LOWER(f.programName) LIKE LOWER(CONCAT('%', :q, '%')) OR LOWER(f.institutionName) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<FeeBreakdown> search(@Param("q") String query);
}

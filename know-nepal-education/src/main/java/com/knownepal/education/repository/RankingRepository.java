package com.knownepal.education.repository;

import com.knownepal.education.model.Ranking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RankingRepository extends JpaRepository<Ranking, Long>, JpaSpecificationExecutor<Ranking> {

    @Query("SELECT r FROM Ranking r WHERE LOWER(r.institutionName) LIKE LOWER(CONCAT('%', :q, '%'))")
    List<Ranking> search(@Param("q") String query);
}

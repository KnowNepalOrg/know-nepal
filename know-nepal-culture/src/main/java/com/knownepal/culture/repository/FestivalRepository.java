package com.knownepal.culture.repository;

import com.knownepal.culture.model.Festival;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface FestivalRepository extends JpaRepository<Festival, Long>, JpaSpecificationExecutor<Festival> {

    Optional<Festival> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<Festival> findByNameContainingIgnoreCase(String name);
}

package com.knownepal.culture.repository;

import com.knownepal.culture.model.TraditionalAttire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface TraditionalAttireRepository extends JpaRepository<TraditionalAttire, Long>, JpaSpecificationExecutor<TraditionalAttire> {

    Optional<TraditionalAttire> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<TraditionalAttire> findByNameContainingIgnoreCase(String name);
}

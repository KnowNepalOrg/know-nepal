package com.knownepal.wildlife.repository;

import com.knownepal.wildlife.model.Lake;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface LakeRepository extends JpaRepository<Lake, Long>, JpaSpecificationExecutor<Lake> {

    Optional<Lake> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<Lake> findByNameContainingIgnoreCase(String name);
}

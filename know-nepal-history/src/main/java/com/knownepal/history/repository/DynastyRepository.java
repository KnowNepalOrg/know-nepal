package com.knownepal.history.repository;

import com.knownepal.history.model.Dynasty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface DynastyRepository extends JpaRepository<Dynasty, Long>, JpaSpecificationExecutor<Dynasty> {

    Optional<Dynasty> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<Dynasty> findByNameContainingIgnoreCase(String name);
}

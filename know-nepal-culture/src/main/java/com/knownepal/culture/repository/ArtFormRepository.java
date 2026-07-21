package com.knownepal.culture.repository;

import com.knownepal.culture.model.ArtForm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ArtFormRepository extends JpaRepository<ArtForm, Long>, JpaSpecificationExecutor<ArtForm> {

    Optional<ArtForm> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<ArtForm> findByNameContainingIgnoreCase(String name);
}

package com.knownepal.culture.repository;

import com.knownepal.culture.model.EthnicGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface EthnicGroupRepository extends JpaRepository<EthnicGroup, Long>, JpaSpecificationExecutor<EthnicGroup> {

    Optional<EthnicGroup> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<EthnicGroup> findByNameContainingIgnoreCase(String name);
}

package com.knownepal.culture.repository;

import com.knownepal.culture.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long>, JpaSpecificationExecutor<Language> {

    Optional<Language> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<Language> findByNameContainingIgnoreCase(String name);
}

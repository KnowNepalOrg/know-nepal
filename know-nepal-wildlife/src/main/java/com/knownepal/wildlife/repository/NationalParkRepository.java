package com.knownepal.wildlife.repository;

import com.knownepal.wildlife.model.NationalPark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface NationalParkRepository extends JpaRepository<NationalPark, Long>, JpaSpecificationExecutor<NationalPark> {

    Optional<NationalPark> findBySlug(String slug);

    boolean existsBySlug(String slug);

    List<NationalPark> findByNameContainingIgnoreCase(String name);
}

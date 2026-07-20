package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.TrekkingRoute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.Optional;

public interface TrekkingRouteRepository extends JpaRepository<TrekkingRoute, Long>,
        JpaSpecificationExecutor<TrekkingRoute> {

    Optional<TrekkingRoute> findBySlug(String slug);

    boolean existsBySlug(String slug);
}

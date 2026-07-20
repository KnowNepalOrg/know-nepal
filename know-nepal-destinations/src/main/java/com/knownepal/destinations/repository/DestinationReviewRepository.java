package com.knownepal.destinations.repository;

import com.knownepal.destinations.model.DestinationReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DestinationReviewRepository extends JpaRepository<DestinationReview, Long> {

    List<DestinationReview> findByDestinationIdOrderByCreatedAtDesc(Long destinationId);

    @Query("SELECT COALESCE(AVG(r.rating), 0.0) FROM DestinationReview r WHERE r.destination.id = :destinationId")
    double avgRatingByDestinationId(@Param("destinationId") Long destinationId);
}

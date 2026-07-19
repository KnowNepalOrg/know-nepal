package com.knownepal.education.specification;

import com.knownepal.education.model.Ranking;
import com.knownepal.education.model.RankingSource;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class RankingSpecification {

    private RankingSpecification() {
    }

    public static Specification<Ranking> build(String institutionType, Long institutionId,
                                                RankingSource source, String year) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (institutionType != null && !institutionType.isBlank()) {
                predicates.add(cb.equal(root.get("institutionType"), institutionType));
            }
            if (institutionId != null) {
                predicates.add(cb.equal(root.get("institutionId"), institutionId));
            }
            if (source != null) {
                predicates.add(cb.equal(root.get("source"), source));
            }
            if (year != null && !year.isBlank()) {
                predicates.add(cb.equal(root.get("year"), year));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

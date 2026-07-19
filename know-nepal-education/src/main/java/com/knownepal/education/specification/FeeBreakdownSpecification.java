package com.knownepal.education.specification;

import com.knownepal.education.model.FeeBreakdown;
import com.knownepal.education.model.FeeComponent;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class FeeBreakdownSpecification {

    private FeeBreakdownSpecification() {
    }

    public static Specification<FeeBreakdown> build(Long programId, Long institutionId,
                                                     FeeComponent component, String academicYear) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (programId != null) {
                predicates.add(cb.equal(root.get("programId"), programId));
            }
            if (institutionId != null) {
                predicates.add(cb.equal(root.get("institutionId"), institutionId));
            }
            if (component != null) {
                predicates.add(cb.equal(root.get("component"), component));
            }
            if (academicYear != null && !academicYear.isBlank()) {
                predicates.add(cb.equal(root.get("academicYear"), academicYear));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

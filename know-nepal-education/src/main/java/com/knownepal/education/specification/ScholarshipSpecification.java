package com.knownepal.education.specification;

import com.knownepal.education.model.Scholarship;
import com.knownepal.education.model.ScholarshipType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class ScholarshipSpecification {

    private ScholarshipSpecification() {
    }

    public static Specification<Scholarship> build(String name, ScholarshipType type, Long provinceId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (type != null) {
                predicates.add(cb.equal(root.get("type"), type));
            }
            if (provinceId != null) {
                predicates.add(cb.equal(root.get("provinceId"), provinceId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

package com.knownepal.education.specification;

import com.knownepal.education.model.School;
import com.knownepal.education.model.SchoolType;
import com.knownepal.education.model.EducationLevel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class SchoolSpecification {

    private SchoolSpecification() {
    }

    public static Specification<School> build(String name, SchoolType type, EducationLevel level,
                                               Long provinceId, Long districtId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (type != null) {
                predicates.add(cb.equal(root.get("type"), type));
            }
            if (level != null) {
                predicates.add(cb.equal(root.get("level"), level));
            }
            if (provinceId != null) {
                predicates.add(cb.equal(root.get("provinceId"), provinceId));
            }
            if (districtId != null) {
                predicates.add(cb.equal(root.get("districtId"), districtId));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

package com.knownepal.education.specification;

import com.knownepal.education.model.QualificationLevel;
import com.knownepal.education.model.TeacherProfile;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class TeacherProfileSpecification {

    private TeacherProfileSpecification() {
    }

    public static Specification<TeacherProfile> build(String name, QualificationLevel level,
                                                       String institutionType, Long provinceId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (level != null) {
                predicates.add(cb.equal(root.get("qualificationLevel"), level));
            }
            if (institutionType != null && !institutionType.isBlank()) {
                predicates.add(cb.equal(root.get("institutionType"), institutionType));
            }
            if (provinceId != null) {
                predicates.add(cb.equal(root.get("provinceId"), provinceId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

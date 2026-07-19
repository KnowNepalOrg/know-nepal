package com.knownepal.education.specification;

import com.knownepal.education.model.Program;
import com.knownepal.education.model.ProgramLevel;
import com.knownepal.education.model.InstitutionType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class ProgramSpecification {

    private ProgramSpecification() {
    }

    public static Specification<Program> build(String name, ProgramLevel level, String faculty,
                                                InstitutionType institutionType) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (level != null) {
                predicates.add(cb.equal(root.get("level"), level));
            }
            if (faculty != null && !faculty.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("faculty")), "%" + faculty.toLowerCase() + "%"));
            }
            if (institutionType != null) {
                predicates.add(cb.equal(root.get("institutionType"), institutionType));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

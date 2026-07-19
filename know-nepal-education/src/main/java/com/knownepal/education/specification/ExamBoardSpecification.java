package com.knownepal.education.specification;

import com.knownepal.education.model.BoardCategory;
import com.knownepal.education.model.ExamBoard;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class ExamBoardSpecification {

    private ExamBoardSpecification() {
    }

    public static Specification<ExamBoard> build(String name, BoardCategory category, Long provinceId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (category != null) {
                predicates.add(cb.equal(root.get("category"), category));
            }
            if (provinceId != null) {
                predicates.add(cb.equal(root.get("provinceId"), provinceId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

package com.knownepal.education.specification;

import com.knownepal.education.model.EntranceExam;
import com.knownepal.education.model.ExamFormat;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class EntranceExamSpecification {

    private EntranceExamSpecification() {
    }

    public static Specification<EntranceExam> build(String name, ExamFormat format, Long boardId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (format != null) {
                predicates.add(cb.equal(root.get("format"), format));
            }
            if (boardId != null) {
                predicates.add(cb.equal(root.get("boardId"), boardId));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

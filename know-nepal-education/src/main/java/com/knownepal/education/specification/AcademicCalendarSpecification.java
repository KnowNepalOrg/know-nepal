package com.knownepal.education.specification;

import com.knownepal.education.model.AcademicCalendar;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class AcademicCalendarSpecification {

    private AcademicCalendarSpecification() {
    }

    public static Specification<AcademicCalendar> build(String institutionType, Long institutionId,
                                                         String academicYear) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();
            if (institutionType != null && !institutionType.isBlank()) {
                predicates.add(cb.equal(root.get("institutionType"), institutionType));
            }
            if (institutionId != null) {
                predicates.add(cb.equal(root.get("institutionId"), institutionId));
            }
            if (academicYear != null && !academicYear.isBlank()) {
                predicates.add(cb.equal(root.get("academicYear"), academicYear));
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

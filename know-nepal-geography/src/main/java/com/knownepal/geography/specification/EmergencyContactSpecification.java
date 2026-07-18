package com.knownepal.geography.specification;

import com.knownepal.geography.model.EmergencyContact;
import com.knownepal.geography.model.EmergencyContactType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class EmergencyContactSpecification {

    private EmergencyContactSpecification() {
    }

    public static Specification<EmergencyContact> build(String name, EmergencyContactType type,
                                                         Boolean isNational, Long districtId,
                                                         Long provinceId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (type != null) {
                predicates.add(cb.equal(root.get("type"), type));
            }
            if (isNational != null) {
                predicates.add(cb.equal(root.get("isNational"), isNational));
            }
            if (districtId != null) {
                predicates.add(cb.equal(root.get("district").get("id"), districtId));
            }
            if (provinceId != null) {
                predicates.add(cb.equal(root.get("province").get("id"), provinceId));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

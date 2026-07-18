package com.knownepal.geography.specification;

import com.knownepal.geography.model.Ward;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class WardSpecification {

    private WardSpecification() {
    }

    public static Specification<Ward> build(String name, Integer number, Long municipalityId,
                                             Long districtId, Long provinceId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (number != null) {
                predicates.add(cb.equal(root.get("number"), number));
            }
            if (municipalityId != null) {
                predicates.add(cb.equal(root.get("municipality").get("id"), municipalityId));
            }
            if (districtId != null) {
                predicates.add(cb.equal(root.get("municipality").get("district").get("id"), districtId));
            }
            if (provinceId != null) {
                predicates.add(cb.equal(root.get("municipality").get("district").get("province").get("id"), provinceId));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

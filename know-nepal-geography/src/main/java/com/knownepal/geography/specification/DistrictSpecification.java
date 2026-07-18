package com.knownepal.geography.specification;

import com.knownepal.geography.model.District;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class DistrictSpecification {

    private DistrictSpecification() {
    }

    public static Specification<District> build(String name, String code, Long provinceId, String headquarters) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (code != null && !code.isBlank()) {
                predicates.add(cb.equal(cb.lower(root.get("code")), code.toLowerCase()));
            }
            if (provinceId != null) {
                predicates.add(cb.equal(root.get("province").get("id"), provinceId));
            }
            if (headquarters != null && !headquarters.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("headquarters")), "%" + headquarters.toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

package com.knownepal.geography.specification;

import com.knownepal.geography.model.Province;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class ProvinceSpecification {

    private ProvinceSpecification() {
    }

    public static Specification<Province> build(String name, String code, String capital) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (code != null && !code.isBlank()) {
                predicates.add(cb.equal(cb.lower(root.get("code")), code.toLowerCase()));
            }
            if (capital != null && !capital.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("capital")), "%" + capital.toLowerCase() + "%"));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

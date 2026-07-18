package com.knownepal.geography.specification;

import com.knownepal.geography.model.Municipality;
import com.knownepal.geography.model.MunicipalityType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public final class MunicipalitySpecification {

    private MunicipalitySpecification() {
    }

    public static Specification<Municipality> build(String name, String code, MunicipalityType type,
                                                     Long districtId, Long provinceId) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isBlank()) {
                predicates.add(cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%"));
            }
            if (code != null && !code.isBlank()) {
                predicates.add(cb.equal(cb.lower(root.get("code")), code.toLowerCase()));
            }
            if (type != null) {
                predicates.add(cb.equal(root.get("type"), type));
            }
            if (districtId != null) {
                predicates.add(cb.equal(root.get("district").get("id"), districtId));
            }
            if (provinceId != null) {
                predicates.add(cb.equal(root.get("district").get("province").get("id"), provinceId));
            }

            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}

package com.knownepal.culture.specification;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class SpecificationFactory {

    private SpecificationFactory() {
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <T> Specification<T> buildSpec(Map<String, String> filters) {
        return (root, query, cb) -> {
            var predicates = new java.util.ArrayList<Predicate>();
            if (filters == null || filters.isEmpty()) {
                return cb.conjunction();
            }
            for (Map.Entry<String, String> entry : filters.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value == null || value.isBlank()) {
                    continue;
                }
                try {
                    Path path = resolvePath(root, key);
                    Class javaType = path.getJavaType();
                    if (javaType == String.class) {
                        predicates.add(cb.like(cb.lower(path), "%" + value.toLowerCase() + "%"));
                    } else if (javaType.isEnum()) {
                        Object enumValue = Enum.valueOf(javaType, value.toUpperCase());
                        predicates.add(cb.equal(path, enumValue));
                    } else if (javaType == Long.class || javaType == long.class) {
                        predicates.add(cb.equal(path, Long.parseLong(value)));
                    } else if (javaType == Integer.class || javaType == int.class) {
                        predicates.add(cb.equal(path, Integer.parseInt(value)));
                    } else if (javaType == Boolean.class || javaType == boolean.class) {
                        predicates.add(cb.equal(path, Boolean.parseBoolean(value)));
                    } else {
                        predicates.add(cb.equal(path, value));
                    }
                } catch (Exception ignored) {
                }
            }
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }

    private static Path<?> resolvePath(Root<?> root, String key) {
        String[] parts = key.split("\\.");
        Path<?> path = root.get(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            path = path.get(parts[i]);
        }
        return path;
    }
}

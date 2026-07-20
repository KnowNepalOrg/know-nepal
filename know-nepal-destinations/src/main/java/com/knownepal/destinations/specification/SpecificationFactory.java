package com.knownepal.destinations.specification;

import org.springframework.data.jpa.domain.Specification;

import java.util.Map;

public class SpecificationFactory {

    private SpecificationFactory() {
    }

    @SuppressWarnings("unchecked")
    public static <T> Specification<T> buildSpec(Map<String, String> filters) {
        return (root, query, cb) -> {
            var predicates = new java.util.ArrayList<jakarta.persistence.criteria.Predicate>();
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
                    var path = resolvePath(root, key);
                    if (path.getJavaType() == String.class) {
                        predicates.add(cb.like(cb.lower(path.as(String.class)), "%" + value.toLowerCase() + "%"));
                    } else if (path.getJavaType().isEnum()) {
                        @SuppressWarnings("rawtypes")
                        Class enumClass = path.getJavaType();
                        predicates.add(cb.equal(path, Enum.valueOf(enumClass, value.toUpperCase())));
                    } else if (path.getJavaType() == Long.class || path.getJavaType() == long.class) {
                        predicates.add(cb.equal(path, Long.parseLong(value)));
                    } else if (path.getJavaType() == Integer.class || path.getJavaType() == int.class) {
                        predicates.add(cb.equal(path, Integer.parseInt(value)));
                    } else if (path.getJavaType() == Boolean.class || path.getJavaType() == boolean.class) {
                        predicates.add(cb.equal(path, Boolean.parseBoolean(value)));
                    } else {
                        predicates.add(cb.equal(path, value));
                    }
                } catch (Exception ignored) {
                }
            }
            return cb.and(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
        };
    }

    private static jakarta.persistence.criteria.Path<?> resolvePath(
            jakarta.persistence.criteria.Root<?> root, String key) {
        String[] parts = key.split("\\.");
        jakarta.persistence.criteria.Path<?> path = root.get(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            path = path.get(parts[i]);
        }
        return path;
    }
}

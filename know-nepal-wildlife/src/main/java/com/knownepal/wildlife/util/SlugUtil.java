package com.knownepal.wildlife.util;

import lombok.experimental.UtilityClass;

import java.util.function.Function;

@UtilityClass
public class SlugUtil {

    public String generate(String name) {
        return name.toLowerCase()
                .replaceAll("[^a-z0-9\\s-]", "")
                .replaceAll("\\s+", "-")
                .replaceAll("-+", "-")
                .replaceAll("^-|-$", "");
    }

    public String generateUnique(String name, Function<String, Boolean> existsChecker) {
        String baseSlug = generate(name);
        String slug = baseSlug;
        int counter = 1;
        while (existsChecker.apply(slug)) {
            slug = baseSlug + "-" + counter++;
        }
        return slug;
    }
}

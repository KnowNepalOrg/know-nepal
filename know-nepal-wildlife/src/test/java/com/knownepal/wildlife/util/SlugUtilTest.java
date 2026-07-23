package com.knownepal.wildlife.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlugUtilTest {

    @Test
    void generateSlug_fromSimpleName() {
        assertEquals("chitwan-national-park", SlugUtil.generate("Chitwan National Park"));
    }

    @Test
    void generateSlug_fromMultiWordName() {
        assertEquals("bengal-tiger", SlugUtil.generate("Bengal Tiger"));
    }

    @Test
    void generateSlug_removesSpecialCharacters() {
        assertEquals("sagarmatha", SlugUtil.generate("Sagarmatha! @#$"));
    }

    @Test
    void generateSlug_collapsesMultipleHyphens() {
        assertEquals("hello-world", SlugUtil.generate("Hello---World"));
    }

    @Test
    void generateSlug_trimsLeadingTrailingHyphens() {
        assertEquals("test", SlugUtil.generate("--test--"));
    }

    @Test
    void generateSlug_emptyString() {
        assertEquals("", SlugUtil.generate(""));
    }

    @Test
    void generateSlug_allSpecialCharacters() {
        assertEquals("", SlugUtil.generate("!@#$%^&*()"));
    }

    @Test
    void generateSlug_preservesNumbers() {
        assertEquals("lake-2025", SlugUtil.generate("Lake 2025"));
    }

    @Test
    void generateUniqueSlug_noConflict() {
        var result = SlugUtil.generateUnique("Chitwan National Park", slug -> false);
        assertEquals("chitwan-national-park", result);
    }

    @Test
    void generateUniqueSlug_withConflict() {
        var result = SlugUtil.generateUnique("Chitwan National Park", slug -> slug.equals("chitwan-national-park"));
        assertEquals("chitwan-national-park-1", result);
    }

    @Test
    void generateSlug_multipleSpaces() {
        assertEquals("the-nepal",
                SlugUtil.generate("  The   Nepal  "));
    }
}

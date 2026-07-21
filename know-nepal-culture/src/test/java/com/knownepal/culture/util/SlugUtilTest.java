package com.knownepal.culture.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlugUtilTest {

    @Test
    void generateSlug_fromSimpleName() {
        assertEquals("nepali", SlugUtil.generate("Nepali"));
    }

    @Test
    void generateSlug_fromMultiWordName() {
        assertEquals("maithili-language", SlugUtil.generate("Maithili Language"));
    }

    @Test
    void generateSlug_removesSpecialCharacters() {
        assertEquals("dashain-festival", SlugUtil.generate("Dashain Festival! @#$"));
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
        assertEquals("nepal-1", SlugUtil.generate("Nepal 1"));
    }

    @Test
    void generateUniqueSlug_noConflict() {
        var result = SlugUtil.generateUnique("Nepali", slug -> false);
        assertEquals("nepali", result);
    }

    @Test
    void generateSlug_multipleSpaces() {
        assertEquals("the-nepal",
                SlugUtil.generate("  The   Nepal  "));
    }
}

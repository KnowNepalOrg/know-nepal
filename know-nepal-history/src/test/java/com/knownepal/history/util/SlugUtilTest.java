package com.knownepal.history.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlugUtilTest {

    @Test
    void generateSlug_fromSimpleName() {
        assertEquals("nepali", SlugUtil.generate("Nepali"));
    }

    @Test
    void generateSlug_fromMultiWordName() {
        assertEquals("prithvi-narayan-shah", SlugUtil.generate("Prithvi Narayan Shah"));
    }

    @Test
    void generateSlug_removesSpecialCharacters() {
        assertEquals("jana-andolan", SlugUtil.generate("Jana Andolan! @#$"));
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
        assertEquals("battle-1816", SlugUtil.generate("Battle 1816"));
    }

    @Test
    void generateUniqueSlug_noConflict() {
        var result = SlugUtil.generateUnique("Prithvi Narayan Shah", slug -> false);
        assertEquals("prithvi-narayan-shah", result);
    }

    @Test
    void generateSlug_multipleSpaces() {
        assertEquals("the-nepal",
                SlugUtil.generate("  The   Nepal  "));
    }
}

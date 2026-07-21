package com.knownepal.culture.validator;

import com.knownepal.culture.model.LanguageFamily;
import com.knownepal.culture.model.RegionType;
import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ValidEnumValidatorTest {

    private ValidEnumValidator validator;
    private ConstraintValidatorContext context;

    @BeforeEach
    void setUp() {
        validator = new ValidEnumValidator();
        context = mock(ConstraintValidatorContext.class);
    }

    @Test
    void initialize_withLanguageFamily_setsValidValues() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) LanguageFamily.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("INDO_ARYAN", context));
    }

    @Test
    void isValid_returnsTrueForValidEnumValue() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) LanguageFamily.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("SINO_TIBETAN", context));
    }

    @Test
    void isValid_returnsFalseForInvalidEnumValue() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) LanguageFamily.class);
        validator.initialize(annotation);
        assertFalse(validator.isValid("INVALID_VALUE", context));
    }

    @Test
    void isValid_returnsTrueForNull() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) LanguageFamily.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid(null, context));
    }

    @Test
    void isValid_returnsTrueForBlank() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) LanguageFamily.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("", context));
    }

    @Test
    void isValid_isCaseInsensitive() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) RegionType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("hill", context));
        assertTrue(validator.isValid("TERAI", context));
        assertTrue(validator.isValid("Himalayan", context));
    }

    @Test
    void isValid_withRegionType() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) RegionType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("HIMALAYAN", context));
        assertTrue(validator.isValid("HILL", context));
        assertTrue(validator.isValid("TERAI", context));
        assertTrue(validator.isValid("URBAN", context));
        assertFalse(validator.isValid("OCEAN", context));
    }
}

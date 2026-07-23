package com.knownepal.wildlife.validator;

import com.knownepal.wildlife.model.ClassType;
import com.knownepal.wildlife.model.ConservationStatus;
import com.knownepal.wildlife.model.LakeType;
import com.knownepal.wildlife.model.NepalStatus;
import com.knownepal.wildlife.model.ProtectedAreaType;
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
    void initialize_withClassType_setsValidValues() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ClassType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("MAMMAL", context));
    }

    @Test
    void isValid_returnsTrueForValidEnumValue() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ConservationStatus.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("ENDANGERED", context));
    }

    @Test
    void isValid_returnsFalseForInvalidEnumValue() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ConservationStatus.class);
        validator.initialize(annotation);
        assertFalse(validator.isValid("INVALID_VALUE", context));
    }

    @Test
    void isValid_returnsTrueForNull() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ConservationStatus.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid(null, context));
    }

    @Test
    void isValid_returnsTrueForBlank() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ConservationStatus.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("", context));
    }

    @Test
    void isValid_isCaseInsensitive() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ClassType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("mammal", context));
        assertTrue(validator.isValid("BIRD", context));
        assertTrue(validator.isValid("Reptile", context));
    }

    @Test
    void isValid_withProtectedAreaType() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ProtectedAreaType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("NATIONAL_PARK", context));
        assertTrue(validator.isValid("WILDLIFE_RESERVE", context));
        assertTrue(validator.isValid("BUFFER_ZONE", context));
        assertFalse(validator.isValid("INVALID", context));
    }

    @Test
    void isValid_withLakeType() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) LakeType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("NATURAL", context));
        assertTrue(validator.isValid("GLACIAL", context));
        assertTrue(validator.isValid("TECTONIC", context));
        assertFalse(validator.isValid("OCEANIC", context));
    }

    @Test
    void isValid_withAllClassTypes() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ClassType.class);
        validator.initialize(annotation);
        for (ClassType type : ClassType.values()) {
            assertTrue(validator.isValid(type.name(), context));
        }
    }

    @Test
    void isValid_withAllConservationStatuses() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) ConservationStatus.class);
        validator.initialize(annotation);
        for (ConservationStatus status : ConservationStatus.values()) {
            assertTrue(validator.isValid(status.name(), context));
        }
    }

    @Test
    void isValid_withAllNepalStatuses() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) NepalStatus.class);
        validator.initialize(annotation);
        for (NepalStatus status : NepalStatus.values()) {
            assertTrue(validator.isValid(status.name(), context));
        }
    }
}

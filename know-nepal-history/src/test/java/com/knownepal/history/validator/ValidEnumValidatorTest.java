package com.knownepal.history.validator;

import com.knownepal.history.model.EventType;
import com.knownepal.history.model.FigureType;
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
    void initialize_withEventType_setsValidValues() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) EventType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("BATTLE", context));
    }

    @Test
    void isValid_returnsTrueForValidEnumValue() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) EventType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("REVOLUTION", context));
    }

    @Test
    void isValid_returnsFalseForInvalidEnumValue() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) EventType.class);
        validator.initialize(annotation);
        assertFalse(validator.isValid("INVALID_VALUE", context));
    }

    @Test
    void isValid_returnsTrueForNull() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) EventType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid(null, context));
    }

    @Test
    void isValid_returnsTrueForBlank() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) EventType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("", context));
    }

    @Test
    void isValid_isCaseInsensitive() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) FigureType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("king", context));
        assertTrue(validator.isValid("WARRIOR", context));
        assertTrue(validator.isValid("Scholar", context));
    }

    @Test
    void isValid_withFigureType() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) FigureType.class);
        validator.initialize(annotation);
        assertTrue(validator.isValid("KING", context));
        assertTrue(validator.isValid("WARRIOR", context));
        assertTrue(validator.isValid("SCHOLAR", context));
        assertTrue(validator.isValid("ACTIVIST", context));
        assertTrue(validator.isValid("DIPLOMAT", context));
        assertFalse(validator.isValid("ALIEN", context));
    }

    @Test
    void isValid_withAllEventTypes() {
        ValidEnum annotation = mock(ValidEnum.class);
        when(annotation.enumClass()).thenReturn((Class) EventType.class);
        validator.initialize(annotation);
        for (EventType type : EventType.values()) {
            assertTrue(validator.isValid(type.name(), context));
        }
    }
}

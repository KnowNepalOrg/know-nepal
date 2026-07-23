package com.knownepal.wildlife.specification;

import com.knownepal.wildlife.model.ClassType;
import com.knownepal.wildlife.model.WildlifeSpecies;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import jakarta.persistence.criteria.Path;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class SpecificationFactoryTest {

    @SuppressWarnings("unchecked")
    @Test
    void buildSpec_withEmptyFilters_returnsConjunction() {
        Map<String, String> filters = new HashMap<>();
        var spec = SpecificationFactory.<WildlifeSpecies>buildSpec(filters);

        Root<WildlifeSpecies> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        Predicate conjunction = mock(Predicate.class);
        when(cb.conjunction()).thenReturn(conjunction);

        Predicate result = spec.toPredicate(root, query, cb);

        verify(cb).conjunction();
        assertEquals(conjunction, result);
    }

    @SuppressWarnings("unchecked")
    @Test
    void buildSpec_withNullFilters_returnsConjunction() {
        var spec = SpecificationFactory.<WildlifeSpecies>buildSpec(null);

        Root<WildlifeSpecies> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        Predicate conjunction = mock(Predicate.class);
        when(cb.conjunction()).thenReturn(conjunction);

        Predicate result = spec.toPredicate(root, query, cb);

        verify(cb).conjunction();
        assertEquals(conjunction, result);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    void buildSpec_withEnumFilter_addsEqualPredicate() {
        Map<String, String> filters = Map.of("classType", "MAMMAL");
        var spec = SpecificationFactory.<WildlifeSpecies>buildSpec(filters);

        Root<WildlifeSpecies> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        Path path = mock(Path.class);
        Predicate equalPredicate = mock(Predicate.class);
        Predicate conjunction = mock(Predicate.class);

        when(root.get("classType")).thenReturn(path);
        when(path.getJavaType()).thenReturn(ClassType.class);
        when(cb.equal(path, ClassType.MAMMAL)).thenReturn(equalPredicate);
        when(cb.conjunction()).thenReturn(conjunction);
        when(cb.and(any(Predicate[].class))).thenReturn(equalPredicate);

        Predicate result = spec.toPredicate(root, query, cb);

        verify(cb).equal(path, ClassType.MAMMAL);
    }

    @SuppressWarnings("unchecked")
    @Test
    void buildSpec_withBlankValue_skipsFilter() {
        Map<String, String> filters = Map.of("classType", "  ");
        var spec = SpecificationFactory.<WildlifeSpecies>buildSpec(filters);

        Root<WildlifeSpecies> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        Predicate conjunction = mock(Predicate.class);
        when(cb.conjunction()).thenReturn(conjunction);

        Predicate result = spec.toPredicate(root, query, cb);

        verify(root, never()).get(anyString());
    }

    @SuppressWarnings("unchecked")
    @Test
    void buildSpec_withBooleanFilter() {
        Map<String, String> filters = Map.of("isFeatured", "true");
        var spec = SpecificationFactory.<WildlifeSpecies>buildSpec(filters);

        Root<WildlifeSpecies> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        Path<?> path = mock(Path.class);
        Predicate equalPredicate = mock(Predicate.class);
        Predicate conjunction = mock(Predicate.class);

        when(root.get("isFeatured")).thenReturn((Path) path);
        when(path.getJavaType()).thenReturn((Class) Boolean.class);
        when(cb.equal(path, true)).thenReturn(equalPredicate);
        when(cb.conjunction()).thenReturn(conjunction);
        when(cb.and(any(Predicate[].class))).thenReturn(equalPredicate);

        Predicate result = spec.toPredicate(root, query, cb);

        verify(cb).equal(path, true);
    }

    @SuppressWarnings({"unchecked", "rawtypes"})
    @Test
    void buildSpec_withStringFilter_usesLike() {
        Map<String, String> filters = Map.of("name", "tiger");
        var spec = SpecificationFactory.<WildlifeSpecies>buildSpec(filters);

        Root<WildlifeSpecies> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        Path path = mock(Path.class);
        Path lowered = mock(Path.class);
        Predicate likePredicate = mock(Predicate.class);
        Predicate conjunction = mock(Predicate.class);

        when(root.get("name")).thenReturn(path);
        when(path.getJavaType()).thenReturn((Class) String.class);
        when(cb.lower(path)).thenReturn(lowered);
        when(cb.like(lowered, "%tiger%")).thenReturn(likePredicate);
        when(cb.conjunction()).thenReturn(conjunction);
        when(cb.and(any(Predicate[].class))).thenReturn(likePredicate);

        Predicate result = spec.toPredicate(root, query, cb);

        verify(cb).like(lowered, "%tiger%");
    }
}

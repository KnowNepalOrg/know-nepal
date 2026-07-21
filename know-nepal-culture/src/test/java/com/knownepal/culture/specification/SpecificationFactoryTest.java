package com.knownepal.culture.specification;

import com.knownepal.culture.model.Festival;
import com.knownepal.culture.model.FestivalType;
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
        var spec = SpecificationFactory.<Festival>buildSpec(filters);

        Root<Festival> root = mock(Root.class);
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
        var spec = SpecificationFactory.<Festival>buildSpec(null);

        Root<Festival> root = mock(Root.class);
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
        Map<String, String> filters = Map.of("festivalType", "HINDU");
        var spec = SpecificationFactory.<Festival>buildSpec(filters);

        Root<Festival> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        Path path = mock(Path.class);
        Predicate equalPredicate = mock(Predicate.class);
        Predicate conjunction = mock(Predicate.class);

        when(root.get("festivalType")).thenReturn(path);
        when(path.getJavaType()).thenReturn(FestivalType.class);
        when(cb.equal(path, FestivalType.HINDU)).thenReturn(equalPredicate);
        when(cb.conjunction()).thenReturn(conjunction);
        when(cb.and(any(Predicate[].class))).thenReturn(equalPredicate);

        Predicate result = spec.toPredicate(root, query, cb);

        verify(cb).equal(path, FestivalType.HINDU);
    }

    @SuppressWarnings("unchecked")
    @Test
    void buildSpec_withBlankValue_skipsFilter() {
        Map<String, String> filters = Map.of("festivalType", "  ");
        var spec = SpecificationFactory.<Festival>buildSpec(filters);

        Root<Festival> root = mock(Root.class);
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
        Map<String, String> filters = Map.of("isPopular", "true");
        var spec = SpecificationFactory.<Festival>buildSpec(filters);

        Root<Festival> root = mock(Root.class);
        CriteriaQuery<?> query = mock(CriteriaQuery.class);
        CriteriaBuilder cb = mock(CriteriaBuilder.class);
        Path<?> path = mock(Path.class);
        Predicate equalPredicate = mock(Predicate.class);
        Predicate conjunction = mock(Predicate.class);

        when(root.get("isPopular")).thenReturn((Path) path);
        when(path.getJavaType()).thenReturn((Class) Boolean.class);
        when(cb.equal(path, true)).thenReturn(equalPredicate);
        when(cb.conjunction()).thenReturn(conjunction);
        when(cb.and(any(Predicate[].class))).thenReturn(equalPredicate);

        Predicate result = spec.toPredicate(root, query, cb);

        verify(cb).equal(path, true);
    }
}

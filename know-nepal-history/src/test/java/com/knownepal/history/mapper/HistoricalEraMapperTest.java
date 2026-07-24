package com.knownepal.history.mapper;

import com.knownepal.history.dto.response.HistoricalEraResponse;
import com.knownepal.history.model.HistoricalEra;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricalEraMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        HistoricalEra entity = new HistoricalEra();
        entity.setId(1L);
        entity.setSlug("rana-oligarchy");
        entity.setName("Rana Oligarchy");
        entity.setDescription("104 years of Rana rule");
        entity.setStartYear(1846);
        entity.setEndYear(1951);
        entity.setKeyCharacteristics("Hereditary PMs, isolation");
        entity.setIsFeatured(true);

        HistoricalEraResponse response = HistoricalEraMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("rana-oligarchy", response.getSlug());
        assertEquals("Rana Oligarchy", response.getName());
        assertEquals("104 years of Rana rule", response.getDescription());
        assertEquals(1846, response.getStartYear());
        assertEquals(1951, response.getEndYear());
        assertEquals("Hereditary PMs, isolation", response.getKeyCharacteristics());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesNullEndYear() {
        HistoricalEra entity = new HistoricalEra();
        entity.setId(10L);
        entity.setSlug("federal-democratic-republic");
        entity.setName("Federal Democratic Republic");
        entity.setStartYear(2008);
        entity.setEndYear(null);
        entity.setIsFeatured(true);

        HistoricalEraResponse response = HistoricalEraMapper.toResponse(entity);

        assertEquals(10L, response.getId());
        assertEquals(2008, response.getStartYear());
        assertNull(response.getEndYear());
    }

    @Test
    void toResponse_handlesNullFeatured() {
        HistoricalEra entity = new HistoricalEra();
        entity.setId(5L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setIsFeatured(null);

        HistoricalEraResponse response = HistoricalEraMapper.toResponse(entity);

        assertNull(response.getIsFeatured());
    }
}

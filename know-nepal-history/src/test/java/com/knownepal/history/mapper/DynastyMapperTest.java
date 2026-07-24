package com.knownepal.history.mapper;

import com.knownepal.history.dto.response.DynastyResponse;
import com.knownepal.history.model.Dynasty;
import com.knownepal.history.model.HistoricalEra;
import com.knownepal.history.model.HistoricalFigure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DynastyMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        HistoricalEra era = new HistoricalEra();
        era.setId(6L);
        era.setName("Gorkha Unification");

        HistoricalFigure founder = new HistoricalFigure();
        founder.setId(14L);
        founder.setName("Prithvi Narayan Shah");

        Dynasty entity = new Dynasty();
        entity.setId(12L);
        entity.setSlug("shah-dynasty-nepal");
        entity.setName("Shah Dynasty (Nepal)");
        entity.setDescription("Kings of unified Nepal");
        entity.setEra(era);
        entity.setFounder(founder);
        entity.setStartYear(1768);
        entity.setEndYear(2008);
        entity.setCapital("Kathmandu");
        entity.setKeyAchievements("Unified Nepal, modernized nation");
        entity.setNumberOfRulers(12);
        entity.setIsFeatured(true);

        DynastyResponse response = DynastyMapper.toResponse(entity);

        assertEquals(12L, response.getId());
        assertEquals("shah-dynasty-nepal", response.getSlug());
        assertEquals("Shah Dynasty (Nepal)", response.getName());
        assertEquals("Kings of unified Nepal", response.getDescription());
        assertEquals(6L, response.getEraId());
        assertEquals("Gorkha Unification", response.getEraName());
        assertEquals(14L, response.getFounderId());
        assertEquals("Prithvi Narayan Shah", response.getFounderName());
        assertEquals(1768, response.getStartYear());
        assertEquals(2008, response.getEndYear());
        assertEquals("Kathmandu", response.getCapital());
        assertEquals("Unified Nepal, modernized nation", response.getKeyAchievements());
        assertEquals(12, response.getNumberOfRulers());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesNullEra() {
        Dynasty entity = new Dynasty();
        entity.setId(1L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setEra(null);
        entity.setFounder(null);

        DynastyResponse response = DynastyMapper.toResponse(entity);

        assertNull(response.getEraId());
        assertNull(response.getEraName());
        assertNull(response.getFounderId());
        assertNull(response.getFounderName());
    }

    @Test
    void toResponse_handlesNullFounder() {
        HistoricalEra era = new HistoricalEra();
        era.setId(3L);
        era.setName("Kirat Period");

        Dynasty entity = new Dynasty();
        entity.setId(3L);
        entity.setSlug("kirat-dynasty");
        entity.setName("Kirat Dynasty");
        entity.setEra(era);
        entity.setFounder(null);

        DynastyResponse response = DynastyMapper.toResponse(entity);

        assertEquals(3L, response.getEraId());
        assertEquals("Kirat Period", response.getEraName());
        assertNull(response.getFounderId());
        assertNull(response.getFounderName());
    }
}

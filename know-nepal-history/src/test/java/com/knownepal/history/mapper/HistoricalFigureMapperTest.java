package com.knownepal.history.mapper;

import com.knownepal.history.dto.response.HistoricalFigureResponse;
import com.knownepal.history.model.FigureType;
import com.knownepal.history.model.HistoricalFigure;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricalFigureMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        HistoricalFigure entity = new HistoricalFigure();
        entity.setId(14L);
        entity.setSlug("prithvi-narayan-shah");
        entity.setName("Prithvi Narayan Shah");
        entity.setDescription("Founder of modern Nepal");
        entity.setFigureType(FigureType.KING);
        entity.setBirthYear(1723);
        entity.setDeathYear(1775);
        entity.setBirthPlace("Gorkha");
        entity.setKnownFor("Unified 50+ kingdoms");
        entity.setKeyAchievements("Unified Nepal, wrote Dibya Upadesh");
        entity.setDynastyAffiliation("Shah Dynasty (Nepal)");
        entity.setEraName("Gorkha Unification");
        entity.setIsFeatured(true);

        HistoricalFigureResponse response = HistoricalFigureMapper.toResponse(entity);

        assertEquals(14L, response.getId());
        assertEquals("prithvi-narayan-shah", response.getSlug());
        assertEquals("Prithvi Narayan Shah", response.getName());
        assertEquals("Founder of modern Nepal", response.getDescription());
        assertEquals("KING", response.getFigureType());
        assertEquals(1723, response.getBirthYear());
        assertEquals(1775, response.getDeathYear());
        assertEquals("Gorkha", response.getBirthPlace());
        assertEquals("Unified 50+ kingdoms", response.getKnownFor());
        assertEquals("Unified Nepal, wrote Dibya Upadesh", response.getKeyAchievements());
        assertEquals("Shah Dynasty (Nepal)", response.getDynastyAffiliation());
        assertEquals("Gorkha Unification", response.getEraName());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesNullEnums() {
        HistoricalFigure entity = new HistoricalFigure();
        entity.setId(2L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setFigureType(null);

        HistoricalFigureResponse response = HistoricalFigureMapper.toResponse(entity);

        assertNull(response.getFigureType());
    }

    @Test
    void toResponse_handlesNullDates() {
        HistoricalFigure entity = new HistoricalFigure();
        entity.setId(5L);
        entity.setSlug("gyanendra");
        entity.setName("Gyanendra");
        entity.setFigureType(FigureType.KING);
        entity.setBirthYear(1947);
        entity.setDeathYear(null);
        entity.setIsFeatured(true);

        HistoricalFigureResponse response = HistoricalFigureMapper.toResponse(entity);

        assertEquals(1947, response.getBirthYear());
        assertNull(response.getDeathYear());
        assertTrue(response.getIsFeatured());
    }
}

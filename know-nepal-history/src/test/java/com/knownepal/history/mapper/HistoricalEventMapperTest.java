package com.knownepal.history.mapper;

import com.knownepal.history.dto.response.HistoricalEventResponse;
import com.knownepal.history.model.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HistoricalEventMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        HistoricalEra era = new HistoricalEra();
        era.setId(6L);
        era.setName("Gorkha Unification");

        Dynasty dynasty = new Dynasty();
        dynasty.setId(12L);
        dynasty.setName("Shah Dynasty (Nepal)");

        HistoricalEvent entity = new HistoricalEvent();
        entity.setId(1L);
        entity.setSlug("fall-of-kathmandu");
        entity.setName("Fall of Kathmandu");
        entity.setDescription("Conquered during Indra Jatra");
        entity.setEventType(EventType.BATTLE);
        entity.setEra(era);
        entity.setDynasty(dynasty);
        entity.setEventYear(1768);
        entity.setEndYear(null);
        entity.setLocation("Kathmandu");
        entity.setSignificance("Capital conquered");
        entity.setKeyFiguresInvolved("Prithvi Narayan Shah");
        entity.setOutcome("Malla rule ends");
        entity.setIsFeatured(true);

        HistoricalEventResponse response = HistoricalEventMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("fall-of-kathmandu", response.getSlug());
        assertEquals("Fall of Kathmandu", response.getName());
        assertEquals("Conquered during Indra Jatra", response.getDescription());
        assertEquals("BATTLE", response.getEventType());
        assertEquals(6L, response.getEraId());
        assertEquals("Gorkha Unification", response.getEraName());
        assertEquals(12L, response.getDynastyId());
        assertEquals("Shah Dynasty (Nepal)", response.getDynastyName());
        assertEquals(1768, response.getEventYear());
        assertNull(response.getEndYear());
        assertEquals("Kathmandu", response.getLocation());
        assertEquals("Capital conquered", response.getSignificance());
        assertEquals("Prithvi Narayan Shah", response.getKeyFiguresInvolved());
        assertEquals("Malla rule ends", response.getOutcome());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesNullDynasty() {
        HistoricalEra era = new HistoricalEra();
        era.setId(8L);
        era.setName("Panchayat Era");

        HistoricalEvent entity = new HistoricalEvent();
        entity.setId(5L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setEventType(EventType.REVOLUTION);
        entity.setEra(era);
        entity.setDynasty(null);

        HistoricalEventResponse response = HistoricalEventMapper.toResponse(entity);

        assertEquals(8L, response.getEraId());
        assertEquals("Panchayat Era", response.getEraName());
        assertNull(response.getDynastyId());
        assertNull(response.getDynastyName());
    }

    @Test
    void toResponse_handlesNullEventType() {
        HistoricalEvent entity = new HistoricalEvent();
        entity.setId(3L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setEventType(null);

        HistoricalEventResponse response = HistoricalEventMapper.toResponse(entity);

        assertNull(response.getEventType());
    }
}

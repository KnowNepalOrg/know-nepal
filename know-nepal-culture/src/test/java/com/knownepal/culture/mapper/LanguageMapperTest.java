package com.knownepal.culture.mapper;

import com.knownepal.culture.dto.response.LanguageResponse;
import com.knownepal.culture.model.Language;
import com.knownepal.culture.model.LanguageFamily;
import com.knownepal.culture.model.LanguageStatus;
import com.knownepal.culture.model.RegionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LanguageMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        Language entity = new Language();
        entity.setId(1L);
        entity.setSlug("nepali");
        entity.setName("Nepali");
        entity.setDescription("Official language");
        entity.setLanguageFamily(LanguageFamily.INDO_ARYAN);
        entity.setLanguageStatus(LanguageStatus.SAFE);
        entity.setSpeakersCount(17000000L);
        entity.setScript("Devanagari");
        entity.setWritingSystem("Devanagari");
        entity.setDialects("Khas, Doteli");
        entity.setIsOfficial(true);
        entity.setIsLinguaFranca(true);
        entity.setRegionType(RegionType.HILL);
        entity.setProvince("All");
        entity.setOriginHistory("From Sanskrit");
        entity.setCulturalSignificance("National identity");
        entity.setEndangeredDetails(null);
        entity.setPreservationEfforts("Constitutional protection");

        LanguageResponse response = LanguageMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("nepali", response.getSlug());
        assertEquals("Nepali", response.getName());
        assertEquals("Official language", response.getDescription());
        assertEquals("INDO_ARYAN", response.getLanguageFamily());
        assertEquals("SAFE", response.getLanguageStatus());
        assertEquals(17000000L, response.getSpeakersCount());
        assertEquals("Devanagari", response.getScript());
        assertEquals("Devanagari", response.getWritingSystem());
        assertEquals("Khas, Doteli", response.getDialects());
        assertTrue(response.getIsOfficial());
        assertTrue(response.getIsLinguaFranca());
        assertEquals("HILL", response.getRegionType());
        assertEquals("All", response.getProvince());
        assertEquals("From Sanskrit", response.getOriginHistory());
        assertEquals("National identity", response.getCulturalSignificance());
        assertNull(response.getEndangeredDetails());
        assertEquals("Constitutional protection", response.getPreservationEfforts());
    }

    @Test
    void toResponse_handlesNullEnums() {
        Language entity = new Language();
        entity.setId(2L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setLanguageFamily(null);
        entity.setLanguageStatus(null);
        entity.setRegionType(null);

        LanguageResponse response = LanguageMapper.toResponse(entity);

        assertNull(response.getLanguageFamily());
        assertNull(response.getLanguageStatus());
        assertNull(response.getRegionType());
    }
}

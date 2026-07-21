package com.knownepal.culture.mapper;

import com.knownepal.culture.dto.response.FestivalResponse;
import com.knownepal.culture.model.CultureSeason;
import com.knownepal.culture.model.Festival;
import com.knownepal.culture.model.FestivalType;
import com.knownepal.culture.model.RegionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FestivalMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        Festival entity = new Festival();
        entity.setId(1L);
        entity.setSlug("dashain");
        entity.setName("Dashain");
        entity.setDescription("The longest festival");
        entity.setFestivalType(FestivalType.HINDU);
        entity.setCultureSeason(CultureSeason.AUTUMN);
        entity.setMonth("Ashwin-Kartik");
        entity.setDay("Shukla Pratipada");
        entity.setDurationDays(15);
        entity.setRegionType(null);
        entity.setIsNationalHoliday(true);
        entity.setIsPublicHoliday(true);
        entity.setSignificance("Triumph of good");
        entity.setRituals("Jamara, Tikka");
        entity.setModernCelebrations("Family gatherings");
        entity.setEthnicGroupsInvolved("All Hindu communities");
        entity.setProvince("All");
        entity.setDistrict("All");
        entity.setIsPopular(true);
        entity.setIsFeatured(true);

        FestivalResponse response = FestivalMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("dashain", response.getSlug());
        assertEquals("Dashain", response.getName());
        assertEquals("The longest festival", response.getDescription());
        assertEquals("HINDU", response.getFestivalType());
        assertEquals("AUTUMN", response.getCultureSeason());
        assertEquals("Ashwin-Kartik", response.getMonth());
        assertEquals("Shukla Pratipada", response.getDay());
        assertEquals(15, response.getDurationDays());
        assertNull(response.getRegionType());
        assertTrue(response.getIsNationalHoliday());
        assertTrue(response.getIsPublicHoliday());
        assertEquals("Triumph of good", response.getSignificance());
        assertEquals("Jamara, Tikka", response.getRituals());
        assertEquals("Family gatherings", response.getModernCelebrations());
        assertEquals("All Hindu communities", response.getEthnicGroupsInvolved());
        assertEquals("All", response.getProvince());
        assertEquals("All", response.getDistrict());
        assertTrue(response.getIsPopular());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesAllEnumTypes() {
        Festival entity = new Festival();
        entity.setId(2L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setFestivalType(FestivalType.NEWAR);
        entity.setCultureSeason(CultureSeason.SPRING);
        entity.setRegionType(RegionType.URBAN);

        FestivalResponse response = FestivalMapper.toResponse(entity);

        assertEquals("NEWAR", response.getFestivalType());
        assertEquals("SPRING", response.getCultureSeason());
        assertEquals("URBAN", response.getRegionType());
    }

    @Test
    void toResponse_handlesNullEnums() {
        Festival entity = new Festival();
        entity.setId(3L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setFestivalType(null);
        entity.setCultureSeason(null);
        entity.setRegionType(null);

        FestivalResponse response = FestivalMapper.toResponse(entity);

        assertNull(response.getFestivalType());
        assertNull(response.getCultureSeason());
        assertNull(response.getRegionType());
    }
}

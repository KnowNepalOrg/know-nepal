package com.knownepal.wildlife.mapper;

import com.knownepal.wildlife.dto.response.WildlifeSpeciesResponse;
import com.knownepal.wildlife.model.ClassType;
import com.knownepal.wildlife.model.ConservationStatus;
import com.knownepal.wildlife.model.NepalStatus;
import com.knownepal.wildlife.model.WildlifeSpecies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WildlifeSpeciesMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        WildlifeSpecies entity = new WildlifeSpecies();
        entity.setId(1L);
        entity.setSlug("bengal-tiger");
        entity.setName("Bengal Tiger");
        entity.setScientificName("Panthera tigris tigris");
        entity.setDescription("Nepal's success story");
        entity.setClassType(ClassType.MAMMAL);
        entity.setConservationStatus(ConservationStatus.ENDANGERED);
        entity.setNepalStatus(NepalStatus.ENDANGERED);
        entity.setHabitat("Tropical forests");
        entity.setElevationRange("150-1200m");
        entity.setEstimatedPopulation("355 (2022 census)");
        entity.setIsEndemic(false);
        entity.setIsFeatured(true);
        entity.setFunFacts("First country to double tiger population");

        WildlifeSpeciesResponse response = WildlifeSpeciesMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("bengal-tiger", response.getSlug());
        assertEquals("Bengal Tiger", response.getName());
        assertEquals("Panthera tigris tigris", response.getScientificName());
        assertEquals("MAMMAL", response.getClassType());
        assertEquals("ENDANGERED", response.getConservationStatus());
        assertEquals("ENDANGERED", response.getNepalStatus());
        assertEquals("Tropical forests", response.getHabitat());
        assertEquals("150-1200m", response.getElevationRange());
        assertEquals("355 (2022 census)", response.getEstimatedPopulation());
        assertFalse(response.getIsEndemic());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesNullEnumFields() {
        WildlifeSpecies entity = new WildlifeSpecies();
        entity.setId(2L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setClassType(null);
        entity.setConservationStatus(null);
        entity.setNepalStatus(null);

        WildlifeSpeciesResponse response = WildlifeSpeciesMapper.toResponse(entity);

        assertNull(response.getClassType());
        assertNull(response.getConservationStatus());
        assertNull(response.getNepalStatus());
    }
}

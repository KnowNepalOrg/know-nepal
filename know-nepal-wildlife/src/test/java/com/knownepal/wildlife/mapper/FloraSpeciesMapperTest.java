package com.knownepal.wildlife.mapper;

import com.knownepal.wildlife.dto.response.FloraSpeciesResponse;
import com.knownepal.wildlife.model.FloraSpecies;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FloraSpeciesMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        FloraSpecies entity = new FloraSpecies();
        entity.setId(1L);
        entity.setSlug("sal-tree");
        entity.setName("Sal Tree");
        entity.setScientificName("Shorea robusta");
        entity.setDescription("Dominant tree of Nepal's Terai");
        entity.setPlantType("Tree");
        entity.setFamilyName("Dipterocarpaceae");
        entity.setHabitat("Tropical forests");
        entity.setElevationRange("100-1000m");
        entity.setIsEndemic(false);
        entity.setIsMedicinal(true);
        entity.setMedicinalUses("Anti-inflammatory");
        entity.setConservationStatus("LEAST_CONCERN");
        entity.setIsFeatured(true);
        entity.setFunFacts("Can live for 200+ years");

        FloraSpeciesResponse response = FloraSpeciesMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("sal-tree", response.getSlug());
        assertEquals("Sal Tree", response.getName());
        assertEquals("Shorea robusta", response.getScientificName());
        assertEquals("Tree", response.getPlantType());
        assertEquals("Dipterocarpaceae", response.getFamilyName());
        assertEquals("Tropical forests", response.getHabitat());
        assertEquals("100-1000m", response.getElevationRange());
        assertFalse(response.getIsEndemic());
        assertTrue(response.getIsMedicinal());
        assertEquals("Anti-inflammatory", response.getMedicinalUses());
        assertEquals("LEAST_CONCERN", response.getConservationStatus());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesNullFields() {
        FloraSpecies entity = new FloraSpecies();
        entity.setId(2L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setIsEndemic(null);
        entity.setIsMedicinal(null);
        entity.setIsFeatured(null);

        FloraSpeciesResponse response = FloraSpeciesMapper.toResponse(entity);

        assertNull(response.getIsEndemic());
        assertNull(response.getIsMedicinal());
        assertNull(response.getIsFeatured());
    }
}

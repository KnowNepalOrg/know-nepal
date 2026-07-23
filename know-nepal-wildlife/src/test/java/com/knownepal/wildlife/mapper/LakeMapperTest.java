package com.knownepal.wildlife.mapper;

import com.knownepal.wildlife.dto.response.LakeResponse;
import com.knownepal.wildlife.model.Lake;
import com.knownepal.wildlife.model.LakeType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LakeMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        Lake entity = new Lake();
        entity.setId(1L);
        entity.setSlug("rara-lake");
        entity.setName("Rara Lake");
        entity.setDescription("Largest lake in Nepal");
        entity.setLakeType(LakeType.NATURAL);
        entity.setDistrict("Mugu");
        entity.setProvince("Karnali");
        entity.setElevationM(2990);
        entity.setAreaSqKm(10.4);
        entity.setMaxDepthM(16);
        entity.setLengthKm(5.1);
        entity.setWidthKm(3.2);
        entity.setNotableFeatures("Nepal's largest lake");
        entity.setIsFeatured(true);

        LakeResponse response = LakeMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("rara-lake", response.getSlug());
        assertEquals("Rara Lake", response.getName());
        assertEquals("Largest lake in Nepal", response.getDescription());
        assertEquals("NATURAL", response.getLakeType());
        assertEquals("Mugu", response.getDistrict());
        assertEquals("Karnali", response.getProvince());
        assertEquals(2990, response.getElevationM());
        assertEquals(10.4, response.getAreaSqKm());
        assertEquals(16, response.getMaxDepthM());
        assertEquals(5.1, response.getLengthKm());
        assertEquals(3.2, response.getWidthKm());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesNullFields() {
        Lake entity = new Lake();
        entity.setId(2L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setLakeType(null);
        entity.setIsFeatured(null);

        LakeResponse response = LakeMapper.toResponse(entity);

        assertNull(response.getLakeType());
        assertNull(response.getIsFeatured());
    }
}

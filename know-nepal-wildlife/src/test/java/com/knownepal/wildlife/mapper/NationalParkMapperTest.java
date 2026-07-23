package com.knownepal.wildlife.mapper;

import com.knownepal.wildlife.dto.response.NationalParkResponse;
import com.knownepal.wildlife.model.NationalPark;
import com.knownepal.wildlife.model.ProtectedAreaType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NationalParkMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        NationalPark entity = new NationalPark();
        entity.setId(1L);
        entity.setSlug("chitwan-national-park");
        entity.setName("Chitwan National Park");
        entity.setDescription("UNESCO World Heritage Site");
        entity.setAreaType(ProtectedAreaType.NATIONAL_PARK);
        entity.setDistrict("Chitwan");
        entity.setProvince("Bagmati");
        entity.setAreaSqKm(932.0);
        entity.setBufferZoneSqKm(750.0);
        entity.setEstablishedYear(1973);
        entity.setElevationMinM(150);
        entity.setElevationMaxM(850);
        entity.setKeySpecies("Bengal tiger, rhinoceros");
        entity.setNotableFeatures("Jungle safaris, elephant breeding center");
        entity.setVisitorCount(200000);
        entity.setIsFeatured(true);

        NationalParkResponse response = NationalParkMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("chitwan-national-park", response.getSlug());
        assertEquals("Chitwan National Park", response.getName());
        assertEquals("UNESCO World Heritage Site", response.getDescription());
        assertEquals("NATIONAL_PARK", response.getAreaType());
        assertEquals("Chitwan", response.getDistrict());
        assertEquals("Bagmati", response.getProvince());
        assertEquals(932.0, response.getAreaSqKm());
        assertEquals(750.0, response.getBufferZoneSqKm());
        assertEquals(1973, response.getEstablishedYear());
        assertEquals(150, response.getElevationMinM());
        assertEquals(850, response.getElevationMaxM());
        assertEquals(200000, response.getVisitorCount());
        assertTrue(response.getIsFeatured());
    }

    @Test
    void toResponse_handlesNullFields() {
        NationalPark entity = new NationalPark();
        entity.setId(5L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setAreaType(null);
        entity.setIsFeatured(null);

        NationalParkResponse response = NationalParkMapper.toResponse(entity);

        assertEquals(5L, response.getId());
        assertNull(response.getAreaType());
        assertNull(response.getIsFeatured());
    }
}

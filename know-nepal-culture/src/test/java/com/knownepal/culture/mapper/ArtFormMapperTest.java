package com.knownepal.culture.mapper;

import com.knownepal.culture.dto.response.ArtFormResponse;
import com.knownepal.culture.model.ArtForm;
import com.knownepal.culture.model.ArtType;
import com.knownepal.culture.model.EthnicGroup;
import com.knownepal.culture.model.RegionType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArtFormMapperTest {

    @Test
    void toResponse_mapsAllFields() {
        EthnicGroup ethnicGroup = new EthnicGroup();
        ethnicGroup.setId(6L);
        ethnicGroup.setName("Newar");
        ethnicGroup.setSlug("newar");

        ArtForm entity = new ArtForm();
        entity.setId(1L);
        entity.setSlug("lakhe-dance");
        entity.setName("Lakhe Dance");
        entity.setDescription("Masked demon dance");
        entity.setArtType(ArtType.FOLK);
        entity.setRegionType(RegionType.URBAN);
        entity.setProvince("Bagmati");
        entity.setHistoricalSignificance("Ancient Newar dance");
        entity.setTechniques("Masked dance");
        entity.setMaterials("Wooden mask");
        entity.setSignificance("Protective dance");
        entity.setContemporaryRelevance("Tourism events");
        entity.setIsIntangibleHeritage(true);
        entity.setEthnicGroup(ethnicGroup);

        ArtFormResponse response = ArtFormMapper.toResponse(entity);

        assertEquals(1L, response.getId());
        assertEquals("lakhe-dance", response.getSlug());
        assertEquals("Lakhe Dance", response.getName());
        assertEquals("Masked demon dance", response.getDescription());
        assertEquals("FOLK", response.getArtType());
        assertEquals("URBAN", response.getRegionType());
        assertEquals("Bagmati", response.getProvince());
        assertEquals("Ancient Newar dance", response.getHistoricalSignificance());
        assertEquals("Masked dance", response.getTechniques());
        assertEquals("Wooden mask", response.getMaterials());
        assertEquals("Protective dance", response.getSignificance());
        assertEquals("Tourism events", response.getContemporaryRelevance());
        assertTrue(response.getIsIntangibleHeritage());
        assertEquals(6L, response.getEthnicGroupId());
        assertEquals("Newar", response.getEthnicGroupName());
    }

    @Test
    void toResponse_handlesNullEthnicGroup() {
        ArtForm entity = new ArtForm();
        entity.setId(2L);
        entity.setSlug("test");
        entity.setName("Test");
        entity.setArtType(ArtType.CLASSICAL);
        entity.setEthnicGroup(null);

        ArtFormResponse response = ArtFormMapper.toResponse(entity);

        assertNull(response.getEthnicGroupId());
        assertNull(response.getEthnicGroupName());
    }
}

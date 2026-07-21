package com.knownepal.culture.mapper;

import com.knownepal.culture.dto.response.ArtFormResponse;
import com.knownepal.culture.model.ArtForm;

public class ArtFormMapper {

    private ArtFormMapper() {
    }

    public static ArtFormResponse toResponse(ArtForm entity) {
        ArtFormResponse response = new ArtFormResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setArtType(entity.getArtType() != null ? entity.getArtType().name() : null);
        if (entity.getEthnicGroup() != null) {
            response.setEthnicGroupId(entity.getEthnicGroup().getId());
            response.setEthnicGroupName(entity.getEthnicGroup().getName());
        }
        response.setRegionType(entity.getRegionType() != null ? entity.getRegionType().name() : null);
        response.setProvince(entity.getProvince());
        response.setHistoricalSignificance(entity.getHistoricalSignificance());
        response.setTechniques(entity.getTechniques());
        response.setMaterials(entity.getMaterials());
        response.setSignificance(entity.getSignificance());
        response.setContemporaryRelevance(entity.getContemporaryRelevance());
        response.setIsIntangibleHeritage(entity.getIsIntangibleHeritage());
        return response;
    }
}

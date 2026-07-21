package com.knownepal.culture.mapper;

import com.knownepal.culture.dto.response.EthnicGroupResponse;
import com.knownepal.culture.model.EthnicGroup;

public class EthnicGroupMapper {

    private EthnicGroupMapper() {
    }

    public static EthnicGroupResponse toResponse(EthnicGroup entity) {
        EthnicGroupResponse response = new EthnicGroupResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setPopulationEstimate(entity.getPopulationEstimate());
        if (entity.getLanguage() != null) {
            response.setLanguageId(entity.getLanguage().getId());
            response.setLanguageName(entity.getLanguage().getName());
        }
        response.setRegionType(entity.getRegionType() != null ? entity.getRegionType().name() : null);
        response.setProvince(entity.getProvince());
        response.setSubRegion(entity.getSubRegion());
        response.setTraditionalOccupation(entity.getTraditionalOccupation());
        response.setSocialStructure(entity.getSocialStructure());
        response.setReligion(entity.getReligion());
        response.setCustoms(entity.getCustoms());
        response.setRituals(entity.getRituals());
        response.setFestivals(entity.getFestivals());
        response.setIsIndigenous(entity.getIsIndigenous());
        response.setIsDeprived(entity.getIsDeprived());
        response.setOrigin(entity.getOrigin());
        response.setMigrationHistory(entity.getMigrationHistory());
        return response;
    }
}

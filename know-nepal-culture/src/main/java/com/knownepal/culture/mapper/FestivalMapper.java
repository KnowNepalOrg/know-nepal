package com.knownepal.culture.mapper;

import com.knownepal.culture.dto.response.FestivalResponse;
import com.knownepal.culture.model.Festival;

public class FestivalMapper {

    private FestivalMapper() {
    }

    public static FestivalResponse toResponse(Festival entity) {
        FestivalResponse response = new FestivalResponse();
        response.setId(entity.getId());
        response.setSlug(entity.getSlug());
        response.setName(entity.getName());
        response.setDescription(entity.getDescription());
        response.setFestivalType(entity.getFestivalType() != null ? entity.getFestivalType().name() : null);
        response.setCultureSeason(entity.getCultureSeason() != null ? entity.getCultureSeason().name() : null);
        response.setMonth(entity.getMonth());
        response.setDay(entity.getDay());
        response.setDurationDays(entity.getDurationDays());
        response.setRegionType(entity.getRegionType() != null ? entity.getRegionType().name() : null);
        response.setIsNationalHoliday(entity.getIsNationalHoliday());
        response.setIsPublicHoliday(entity.getIsPublicHoliday());
        response.setSignificance(entity.getSignificance());
        response.setRituals(entity.getRituals());
        response.setModernCelebrations(entity.getModernCelebrations());
        response.setEthnicGroupsInvolved(entity.getEthnicGroupsInvolved());
        response.setProvince(entity.getProvince());
        response.setDistrict(entity.getDistrict());
        response.setIsPopular(entity.getIsPopular());
        response.setIsFeatured(entity.getIsFeatured());
        return response;
    }
}

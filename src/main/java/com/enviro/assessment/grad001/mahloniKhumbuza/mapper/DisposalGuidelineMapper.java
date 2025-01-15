package com.enviro.assessment.grad001.mahloniKhumbuza.mapper;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.DisposalGuideline;

public class DisposalGuidelineMapper {
    public static DisposalGuidelineDTO mapToDisposalGuidelineDto(DisposalGuideline disposalGuideline, DisposalGuidelineDTO disposalGuidelineDTO) {
        disposalGuidelineDTO.setGuideline(disposalGuideline.getGuideline());
        disposalGuidelineDTO.setHazardous(disposalGuideline.isHazardous());
        disposalGuidelineDTO.setWasteCategoryId(disposalGuideline.getWasteCategoryId());
        return disposalGuidelineDTO;
    }

    public static DisposalGuideline mapToDisposalGuideline(DisposalGuidelineDTO disposalGuidelineDTO, DisposalGuideline disposalGuideline) {
        disposalGuideline.setGuideline(disposalGuidelineDTO.getGuideline());
        disposalGuideline.setWasteCategoryId(disposalGuidelineDTO.getWasteCategoryId());
        disposalGuideline.setHazardous(disposalGuidelineDTO.isHazardous());
        return disposalGuideline;
    }
}

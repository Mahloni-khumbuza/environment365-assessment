package com.enviro.assessment.grad001.mahloniKhumbuza.mapper;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.RecyclingTipDto;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.RecyclingTip;

public class RecyclingTipMapper {

    public static RecyclingTipDto mapToRecyclingTipDto(RecyclingTip recyclingTip, RecyclingTipDto recyclingTipDto) {
        recyclingTipDto.setWasteCategoryId(recyclingTip.getWasteCategoryId());
        recyclingTipDto.setTip(recyclingTip.getTip());
        return recyclingTipDto;
    }

    public static RecyclingTip mapToRecyclingTip(RecyclingTipDto recyclingTipDto, RecyclingTip recyclingTip) {
        recyclingTip.setWasteCategoryId(recyclingTipDto.getWasteCategoryId());
        recyclingTip.setTip(recyclingTipDto.getTip());
        return recyclingTip;
    }
}

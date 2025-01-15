package com.enviro.assessment.grad001.mahloniKhumbuza.mapper;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.WasteCategory;

public class WasteCategoryMapper {

    public static WasteCategoryDTO mapToWasteCategoryDto(WasteCategory wasteCategory, WasteCategoryDTO wasteCategoryDTO) {
        wasteCategoryDTO.setDescription(wasteCategory.getDescription());
        wasteCategoryDTO.setName(wasteCategory.getName());
        return wasteCategoryDTO;
    }

    public static WasteCategory mapToWasteCategory(WasteCategoryDTO wasteCategoryDTO, WasteCategory wasteCategory) {
        wasteCategory.setDescription(wasteCategoryDTO.getDescription());
        wasteCategory.setName(wasteCategoryDTO.getName());
        return wasteCategory;
    }
}

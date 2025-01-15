package com.enviro.assessment.grad001.mahloniKhumbuza.service;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.WasteCategory;

import java.util.List;

public interface WasteCategoryService {

    /**
     * @param wasteCategoryDTO - CustomerDto Object
     */
    WasteCategory save(WasteCategoryDTO wasteCategoryDTO);

    /**
     * @return Returns a list of all waste Categories
     */
    List<WasteCategory> findAllWasteCategories();

    /**
     *
     * @param id - Input Mobile Number
     * @return Waste Category Details based on a given id
     */
    WasteCategoryDTO fetchWasteCategory(Long id);

    /**
     *
     * @param wasteCategoryDTO - CustomerDto Object
     * @return boolean if the update of the WasteCategory details is successful or not
     */
    WasteCategoryDTO updateWasteCategory(Long id, WasteCategoryDTO wasteCategoryDTO);


    /**
     *
     * @param id - Input Mobile Number
     * @return boolean indicating if the deletion of WasteCategory details is successful or not
     */
    boolean deleteWasteCategory(Long id);
}

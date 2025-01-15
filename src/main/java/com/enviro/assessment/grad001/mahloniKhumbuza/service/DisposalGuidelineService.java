package com.enviro.assessment.grad001.mahloniKhumbuza.service;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.DisposalGuideline;

import java.util.List;

public interface DisposalGuidelineService {
    /**
     * @param disposalGuidelineDTO - CustomerDto Object
     */
    DisposalGuideline save(DisposalGuidelineDTO disposalGuidelineDTO);

    /**
     * @return Returns a list of all waste Categories
     */
    List<DisposalGuideline> findAll();

    /**
     *
     * @param id - Input Mobile Number
     * @return Waste Category Details based on a given id
     */
    DisposalGuidelineDTO fetch(Long id);

    /**
     *
     * @param disposalGuidelineDTO - CustomerDto Object
     * @return boolean if the update of the WasteCategory details is successful or not
     */
    DisposalGuidelineDTO update(Long id, DisposalGuidelineDTO disposalGuidelineDTO);


    /**
     *
     * @param id - Input Mobile Number
     * @return boolean indicating if the deletion of WasteCategory details is successful or not
     */
    boolean delete(Long id);
}

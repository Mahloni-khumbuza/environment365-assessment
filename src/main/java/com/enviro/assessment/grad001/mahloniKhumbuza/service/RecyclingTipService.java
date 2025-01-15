package com.enviro.assessment.grad001.mahloniKhumbuza.service;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.RecyclingTipDto;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.RecyclingTip;

import java.util.List;

public interface RecyclingTipService {
    /**
     * @param recyclingTipDto - CustomerDto Object
     */
    RecyclingTip save(RecyclingTipDto recyclingTipDto);

    /**
     * @return Returns a list of all recycling tips
     */
    List<RecyclingTip> findAll();

    /**
     *
     * @param id - Input Mobile Number
     * @return Waste Category Details based on a given id
     */
    RecyclingTipDto fetch(Long id);

    /**
     *
     * @param recyclingTipDto - CustomerDto Object
     * @return boolean if the update of the WasteCategory details is successful or not
     */
    RecyclingTipDto update(Long id, RecyclingTipDto recyclingTipDto);


    /**
     *
     * @param id - Input Mobile Number
     * @return boolean indicating if the deletion of WasteCategory details is successful or not
     */
    boolean delete(Long id);
}

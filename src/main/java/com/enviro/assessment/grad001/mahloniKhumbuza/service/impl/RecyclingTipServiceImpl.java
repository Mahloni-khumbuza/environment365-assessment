package com.enviro.assessment.grad001.mahloniKhumbuza.service.impl;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.RecyclingTipDto;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.RecyclingTip;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.WasteCategory;
import com.enviro.assessment.grad001.mahloniKhumbuza.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.mahloniKhumbuza.exceptions.WasteCategoryNotFoundException;
import com.enviro.assessment.grad001.mahloniKhumbuza.mapper.RecyclingTipMapper;
import com.enviro.assessment.grad001.mahloniKhumbuza.repository.RecyclingTipRepository;
import com.enviro.assessment.grad001.mahloniKhumbuza.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.mahloniKhumbuza.service.RecyclingTipService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Data
@Service
public class RecyclingTipServiceImpl implements RecyclingTipService {

    private final RecyclingTipRepository recyclingTipRepository;

    private final WasteCategoryRepository wasteCategoryRepository;

    @Override
    public RecyclingTip save(RecyclingTipDto recyclingTipDto) {
        Long wasteCategoryId = recyclingTipDto.getWasteCategoryId();
        Optional<WasteCategory> optionalWasteCategory =
                wasteCategoryRepository.findById(wasteCategoryId);


        if(optionalWasteCategory.isEmpty()) {
            throw new ResourceNotFoundException("Can't create a recycling tip for a non-existent waste category with id: "+ wasteCategoryId);
        } else {
            RecyclingTip recyclingTip = RecyclingTipMapper.mapToRecyclingTip(recyclingTipDto, new RecyclingTip());
            return recyclingTipRepository.save(recyclingTip);
        }
    }

    @Override
    public List<RecyclingTip> findAll() {
        List<RecyclingTip> retrievedRecyclingTip = recyclingTipRepository.findAll();

        if (retrievedRecyclingTip.isEmpty())
            throw new ResourceNotFoundException("No records found");

        return retrievedRecyclingTip;
    }

    @Override
    public RecyclingTipDto fetch(Long id) {
        Optional<RecyclingTip> optionalRecyclingTip = recyclingTipRepository.findById(id);

        if (optionalRecyclingTip.isPresent()) {
            return RecyclingTipMapper.mapToRecyclingTipDto(optionalRecyclingTip.get(), new RecyclingTipDto());
        } else {
            throw new WasteCategoryNotFoundException("Disposal guideline with id: " + id + " does not exist");
        }
    }

    @Override
    public RecyclingTipDto update(Long id, RecyclingTipDto recyclingTipDto) {
        return recyclingTipRepository.findById(id)
                .map(recyclingTip -> {
                    recyclingTip.setTip(recyclingTipDto.getTip());
                    return RecyclingTipMapper.mapToRecyclingTipDto(recyclingTipRepository.save(recyclingTip), new RecyclingTipDto());
                })
                .orElseThrow(() -> new WasteCategoryNotFoundException("Waste category not found with id " + id));
    }

    @Override
    public boolean delete(Long id) {
        RecyclingTip recyclingTip = recyclingTipRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Recycling tip with id: " + id + " does not exist")
        );
        wasteCategoryRepository.deleteById(id);
        return true;
    }
}

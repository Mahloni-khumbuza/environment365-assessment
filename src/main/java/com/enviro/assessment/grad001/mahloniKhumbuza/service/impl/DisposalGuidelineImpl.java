package com.enviro.assessment.grad001.mahloniKhumbuza.service.impl;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.DisposalGuideline;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.WasteCategory;
import com.enviro.assessment.grad001.mahloniKhumbuza.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.mahloniKhumbuza.exceptions.WasteCategoryNotFoundException;
import com.enviro.assessment.grad001.mahloniKhumbuza.mapper.DisposalGuidelineMapper;
import com.enviro.assessment.grad001.mahloniKhumbuza.repository.DisposalGuidelineRepository;
import com.enviro.assessment.grad001.mahloniKhumbuza.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.mahloniKhumbuza.service.DisposalGuidelineService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;;

@Slf4j
@RequiredArgsConstructor
@Data
@Service
public class DisposalGuidelineImpl implements DisposalGuidelineService {

    private final DisposalGuidelineRepository disposalGuidelineRepository;

    private final WasteCategoryRepository wasteCategoryRepository;

    @Override
    public DisposalGuideline save(DisposalGuidelineDTO disposalGuidelineDTO) {

        Long wasteCategoryId = disposalGuidelineDTO.getWasteCategoryId();
        Optional<WasteCategory> optionalWasteCategory =
                wasteCategoryRepository.findById(wasteCategoryId);


        if(optionalWasteCategory.isEmpty()) {
            throw new WasteCategoryNotFoundException("Can't create a guideline for a non-existent waste category with id: "+ wasteCategoryId);
        } else {
            DisposalGuideline disposalGuideline = DisposalGuidelineMapper.mapToDisposalGuideline(disposalGuidelineDTO, new DisposalGuideline());
            return disposalGuidelineRepository.save(disposalGuideline);
        }
    }

    @Override
    public List<DisposalGuideline> findAll() {
        List<DisposalGuideline> retrievedGuidelines = disposalGuidelineRepository.findAll();

        if (retrievedGuidelines.isEmpty())
            throw new ResourceNotFoundException("No records found");

        return retrievedGuidelines;
    }

    @Override
    public DisposalGuidelineDTO fetch(Long id) {
        Optional<DisposalGuideline> optionalDisposalGuideline = disposalGuidelineRepository.findById(id);

        if (optionalDisposalGuideline.isPresent()) {
            return DisposalGuidelineMapper.mapToDisposalGuidelineDto(optionalDisposalGuideline.get(), new DisposalGuidelineDTO());
        } else {
            throw new WasteCategoryNotFoundException("Disposal guideline with id: " + id + " does not exist");
        }
    }

    @Override
    public DisposalGuidelineDTO update(Long id, DisposalGuidelineDTO disposalGuidelineDTO) {
        return disposalGuidelineRepository.findById(id)
                .map(disposalGuideline -> {
                    disposalGuideline.setGuideline(disposalGuidelineDTO.getGuideline());
                    disposalGuideline.setHazardous(disposalGuidelineDTO.isHazardous());
                    return DisposalGuidelineMapper.mapToDisposalGuidelineDto(disposalGuidelineRepository.save(disposalGuideline), new DisposalGuidelineDTO());
                })
                .orElseThrow(() -> new WasteCategoryNotFoundException("Waste category not found with id " + id));
    }

    @Override
    public boolean delete(Long id) {
        DisposalGuideline disposalGuideline = disposalGuidelineRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Waste category with id: " + id + " does not exist")
        );
        wasteCategoryRepository.deleteById(id);
        return true;
    }
}

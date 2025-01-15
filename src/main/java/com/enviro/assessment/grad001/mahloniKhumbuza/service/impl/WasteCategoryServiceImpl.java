package com.enviro.assessment.grad001.mahloniKhumbuza.service.impl;

import com.enviro.assessment.grad001.mahloniKhumbuza.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.WasteCategory;
import com.enviro.assessment.grad001.mahloniKhumbuza.exceptions.ResourceNotFoundException;
import com.enviro.assessment.grad001.mahloniKhumbuza.exceptions.WasteCategoryAlreadyExistException;
import com.enviro.assessment.grad001.mahloniKhumbuza.exceptions.WasteCategoryNotFoundException;
import com.enviro.assessment.grad001.mahloniKhumbuza.mapper.WasteCategoryMapper;
import com.enviro.assessment.grad001.mahloniKhumbuza.repository.WasteCategoryRepository;
import com.enviro.assessment.grad001.mahloniKhumbuza.service.WasteCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WasteCategoryServiceImpl implements WasteCategoryService {

    private final WasteCategoryRepository wasteCategoryRepository;

    @Override
    public WasteCategory save(WasteCategoryDTO wasteCategoryDTO) {

        WasteCategory wasteCategory = WasteCategoryMapper.mapToWasteCategory(wasteCategoryDTO, new WasteCategory());

        Optional<WasteCategory> optionalWasteCategory = wasteCategoryRepository.findByName(wasteCategoryDTO.getName());

        if (optionalWasteCategory.isPresent()) {
            throw new WasteCategoryAlreadyExistException("Waste category with name " + wasteCategory.getName() + " already exists");
        } else {
            return wasteCategoryRepository.save(wasteCategory);
        }
    }

    @Override
    public List<WasteCategory> findAllWasteCategories() {
        List<WasteCategory> retrievedCategories = wasteCategoryRepository.findAll();

        if (retrievedCategories.isEmpty())
            throw new ResourceNotFoundException("No records found");

        return retrievedCategories;
    }

    @Override
    public WasteCategoryDTO fetchWasteCategory(Long id) {
        Optional<WasteCategory> optionalWasteCategory = wasteCategoryRepository.findById(id);

        if (optionalWasteCategory.isPresent()) {
            return WasteCategoryMapper.mapToWasteCategoryDto(optionalWasteCategory.get(), new WasteCategoryDTO());
        } else {
            throw new WasteCategoryNotFoundException("waste category with id: " + id + " does not exist");
        }
    }

    @Override
    public WasteCategoryDTO updateWasteCategory(Long id, WasteCategoryDTO wasteCategoryDTO) {
        return wasteCategoryRepository.findById(id)
                .map(wasteCategory -> {
                    wasteCategory.setDescription(wasteCategoryDTO.getDescription());
                    wasteCategory.setName(wasteCategoryDTO.getName());
                    return WasteCategoryMapper.mapToWasteCategoryDto(wasteCategoryRepository.save(wasteCategory), new WasteCategoryDTO());
                })
                .orElseThrow(() -> new WasteCategoryNotFoundException("Waste category not found with id " + id));
    }

    @Override
    public boolean deleteWasteCategory(Long id) {
        WasteCategory wasteCategory = wasteCategoryRepository.findById(id).orElseThrow(
                () -> new WasteCategoryNotFoundException("Waste category with id: " + id + " does not exist")
        );
        wasteCategoryRepository.deleteById(id);
        return true;
    }
}

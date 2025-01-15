package com.enviro.assessment.grad001.mahloniKhumbuza.controllers;

import com.enviro.assessment.grad001.mahloniKhumbuza.constants.ResponseMessageConstants;
import com.enviro.assessment.grad001.mahloniKhumbuza.dto.ResponseDto;
import com.enviro.assessment.grad001.mahloniKhumbuza.dto.WasteCategoryDTO;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.WasteCategory;
import com.enviro.assessment.grad001.mahloniKhumbuza.service.WasteCategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/waste-categories")
@Validated
public class WasteCategoryController {

    private final WasteCategoryService wasteCategoryService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> saveWasteCategory(@Valid @RequestBody WasteCategoryDTO wasteCategoryDTO) {
        WasteCategory savedCategory = wasteCategoryService.save(wasteCategoryDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_201, ResponseMessageConstants.MESSAGE_201, savedCategory));
    }

    @GetMapping("/find-all")
    public ResponseEntity<ResponseDto> findAll() {
        List<WasteCategory> allWasteCategories = wasteCategoryService.findAllWasteCategories();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, allWasteCategories));
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<ResponseDto> fetchWasteCategoryById(@RequestParam Long id) {
        WasteCategoryDTO fetchedWasteCategory = wasteCategoryService.fetchWasteCategory(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, fetchedWasteCategory));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateWasteCategory(@RequestParam Long id, @Valid @RequestBody WasteCategoryDTO wasteCategoryDTO) {
        WasteCategoryDTO fetchedWasteCategory = wasteCategoryService.updateWasteCategory(id, wasteCategoryDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, fetchedWasteCategory));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestParam Long id) {
        boolean isDeleted = wasteCategoryService.deleteWasteCategory(id);

        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, isDeleted));
        }else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(ResponseMessageConstants.STATUS_417, ResponseMessageConstants.MESSAGE_417_DELETE, isDeleted));
        }
    }
}

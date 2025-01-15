package com.enviro.assessment.grad001.mahloniKhumbuza.controllers;

import com.enviro.assessment.grad001.mahloniKhumbuza.constants.ResponseMessageConstants;
import com.enviro.assessment.grad001.mahloniKhumbuza.dto.RecyclingTipDto;
import com.enviro.assessment.grad001.mahloniKhumbuza.dto.ResponseDto;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.RecyclingTip;
import com.enviro.assessment.grad001.mahloniKhumbuza.service.RecyclingTipService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/recycling-tips")
@Validated
public class RecyclingTipController {

    private final RecyclingTipService recyclingTipService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@Valid @RequestBody RecyclingTipDto recyclingTipDto) {
        RecyclingTip savedRecyclingTip = recyclingTipService.save(recyclingTipDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_201, ResponseMessageConstants.MESSAGE_201, savedRecyclingTip));
    }

    @GetMapping("/find-all")
    public ResponseEntity<ResponseDto> findAll() {
        List<RecyclingTip> allDisposalGuidelines = recyclingTipService.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, allDisposalGuidelines));
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<ResponseDto> fetch(@RequestParam Long id) {
        RecyclingTipDto fetchedRecyclingTip = recyclingTipService.fetch(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, fetchedRecyclingTip));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestParam Long id, @Valid @RequestBody RecyclingTipDto recyclingTipDto) {
        RecyclingTipDto fetchedRecyclingTip = recyclingTipService.update(id, recyclingTipDto);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, fetchedRecyclingTip));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestParam Long id) {
        boolean isDeleted = recyclingTipService.delete(id);

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

package com.enviro.assessment.grad001.mahloniKhumbuza.controllers;

import com.enviro.assessment.grad001.mahloniKhumbuza.constants.ResponseMessageConstants;
import com.enviro.assessment.grad001.mahloniKhumbuza.dto.DisposalGuidelineDTO;
import com.enviro.assessment.grad001.mahloniKhumbuza.dto.ResponseDto;
import com.enviro.assessment.grad001.mahloniKhumbuza.entity.DisposalGuideline;
import com.enviro.assessment.grad001.mahloniKhumbuza.service.DisposalGuidelineService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/disposal-guidelines")
@Validated
public class DisposalGuidelineController {

    private final DisposalGuidelineService disposalGuidelineService;

    @PostMapping("/save")
    public ResponseEntity<ResponseDto> save(@Valid @RequestBody DisposalGuidelineDTO disposalGuidelineDTO) {
        DisposalGuideline savedGuideline = disposalGuidelineService.save(disposalGuidelineDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_201, ResponseMessageConstants.MESSAGE_201, savedGuideline));
    }

    @GetMapping("/find-all")
    public ResponseEntity<ResponseDto> findAll() {
        List<DisposalGuideline> allDisposalGuidelines = disposalGuidelineService.findAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, allDisposalGuidelines));
    }

    @GetMapping("/find-by-id")
    public ResponseEntity<ResponseDto> fetch(@RequestParam Long id) {
        DisposalGuidelineDTO fetchedDisposalGuideline = disposalGuidelineService.fetch(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, fetchedDisposalGuideline));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> update(@RequestParam Long id, @Valid @RequestBody DisposalGuidelineDTO disposalGuidelineDTO) {
        DisposalGuidelineDTO fetchedDisposalGuideline = disposalGuidelineService.update(id, disposalGuidelineDTO);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new ResponseDto(ResponseMessageConstants.STATUS_200, ResponseMessageConstants.MESSAGE_200, fetchedDisposalGuideline));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@RequestParam Long id) {
        boolean isDeleted = disposalGuidelineService.delete(id);

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

package com.enviro.assessment.grad001.mahloniKhumbuza.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DisposalGuidelineDTO {
    @NotEmpty(message = "wasteCategoryId cannot be a null or empty")
    private Long wasteCategoryId;

    @NotEmpty(message = "guideline cannot be a null or empty")
    private String guideline;

    @NotEmpty(message = "hazardous cannot be a null or empty")
    private boolean hazardous;
}

package com.enviro.assessment.grad001.mahloniKhumbuza.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class RecyclingTipDto {
    @NotEmpty(message = "wasteCategoryId cannot be a null or empty")
    private Long wasteCategoryId;

    @NotEmpty(message = "tip cannot be a null or empty")
    private String tip;
}

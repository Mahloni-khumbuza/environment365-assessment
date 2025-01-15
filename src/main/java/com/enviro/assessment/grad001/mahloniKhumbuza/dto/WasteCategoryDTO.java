package com.enviro.assessment.grad001.mahloniKhumbuza.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WasteCategoryDTO {
    @NotEmpty(message = "name cannot be a null or empty")
    private String name;

    @NotEmpty(message = "description cannot be a null or empty")
    private String description;
}

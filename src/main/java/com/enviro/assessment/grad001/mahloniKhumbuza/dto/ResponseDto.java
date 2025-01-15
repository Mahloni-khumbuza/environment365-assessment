package com.enviro.assessment.grad001.mahloniKhumbuza.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {

    private String statusCode;

    private String statusMsg;

    private Object results;

}

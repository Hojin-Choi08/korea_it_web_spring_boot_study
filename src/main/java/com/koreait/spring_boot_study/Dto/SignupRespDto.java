package com.koreait.spring_boot_study.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignupRespDto {
    private String status;
    private String message;
}

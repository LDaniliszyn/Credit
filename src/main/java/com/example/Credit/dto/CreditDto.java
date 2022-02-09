package com.example.Credit.dto;

import lombok.Builder;
import lombok.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Value
@Builder
public class CreditDto {
    @NotBlank
    String creditName;
    @Min(value = 0)
    double value;
}

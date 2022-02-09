package com.example.Credit.dto;


import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@Value
public class CreateCreditRequest {
    @Valid
    @NotNull
    CustomerDto customerDto;
    @Valid
    @NotNull
    CreditDto creditDto;

}

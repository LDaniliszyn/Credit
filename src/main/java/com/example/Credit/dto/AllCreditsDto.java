package com.example.Credit.dto;

import lombok.Builder;

import javax.persistence.Column;
@Builder
public class AllCreditsDto {
    public CustomerDto customerDto;
    public CreditDto creditDto;

}

package com.example.Credit.dto;


import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

//@Value
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDto {
    Long ID;
    String firstName;
    String lastName;
    String pesel;

}

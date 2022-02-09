package com.example.Credit.testEndpointa;

import com.example.Credit.dto.CustomerDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Endpoint {

    @PostMapping("/customer/filtered")
    public List<CustomerDto> ludzie(@RequestBody Long[] longs){
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customerDtoList.add(new CustomerDto(19423L,"Jan","Kowalski","76051728798"));
       return customerDtoList;
    }
}

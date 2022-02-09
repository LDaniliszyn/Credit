package com.example.Credit.service;

import com.example.Credit.dto.AllCreditsDto;
import com.example.Credit.dto.CreateCreditRequest;
import com.example.Credit.dto.CreditDto;
import com.example.Credit.dto.CustomerDto;
import com.example.Credit.model.Credit;
import com.example.Credit.model.CreditRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class CreditService {
    CreditRepository creditRepository;

    public CreditService(CreditRepository creditRepository) {
        this.creditRepository = creditRepository;
    }

    public void save(){
        creditRepository.save(new Credit("kredyt1",19423L,100.0));
        creditRepository.save(new Credit("kredyt2",22523L,200.0));
    }

    private boolean isRequestValid(CreateCreditRequest createCreditRequest){

    }




    public List getCredits() {


        List<Credit> all = creditRepository.findAll();
        List<Long> collect = all.stream().map(Credit::getCustomerID).collect(Collectors.toList());

        RestTemplate restTemplate = new RestTemplate();
        try {
            CustomerDto[] customerDto = restTemplate.postForObject("http://localhost:8080/customer/filtered", collect, CustomerDto[].class); //200
        }catch (HttpServerErrorException)




        List<AllCreditsDto> allCreditsDto = new ArrayList<>();

        List<CustomerDto> lista = Arrays.asList(customerDto);


        for (Credit credit : all) {

            CustomerDto customerDto2 = lista.stream().filter(customerDto1 -> customerDto1.getID().equals(credit.getCustomerID())).findFirst().get();

            allCreditsDto.add(AllCreditsDto.builder()
                    .customerDto(CustomerDto.builder()
                            .ID(customerDto2.getID())
                            .firstName(customerDto2.getFirstName())
                            .lastName(customerDto2.getLastName())
                            .pesel(customerDto2.getPesel())
                            .build())
                    .creditDto(CreditDto.builder()
                            .creditName(credit.getCreditName())
                            .value(credit.getValue())
                            .build())
                    .build());
        }
        return allCreditsDto;
    }


    public void addCredit(CreateCreditRequest createCreditRequest){
        creditRepository.save(Credit.builder()
                .creditName(createCreditRequest.getCreditDto().getCreditName())
                .build());
    }

    public Integer createCredit(CreateCreditRequest createCreditRequest) {
        if (!isRequestValid(createCreditRequest)){
            throw new RuntimeException("request is not valid");
        }
        throw new RuntimeException("dfsdf");

    }
}

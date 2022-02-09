package com.example.Credit.controller;

import com.example.Credit.dto.CreateCreditRequest;
import com.example.Credit.errorHandling.CustomerNotFoundException;
import com.example.Credit.errorHandling.ErrorResponse;
import com.example.Credit.service.CreditService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
public class CreditController {
    private final CreditService creditService;

    /**
     *
     * @param createCreditRequest
     * @return
     */
    @ApiOperation(value = "Create new credit on db")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK - credit created with id: ", response = Integer.class),
            @ApiResponse(code = 400, message = "Bad Request", response = ErrorResponse.class),
            @ApiResponse(code = 404, message = "Not Found", response = ErrorResponse.class)
    })


    @PostMapping(value = "/createcredit" )
    public ResponseEntity<CreateCreditRequest> CreateCredit(@RequestBody @Valid CreateCreditRequest createCreditRequest){
        creditService.addCredit(createCreditRequest);
        log.info("{}",createCreditRequest);


        if (createCreditRequest.getCreditDto().getValue()==5){
            throw new CustomerNotFoundException();
        }
        return ResponseEntity.ok(createCreditRequest);
    }

    @PostMapping(value = "/createcredit2" )
    public ResponseEntity<CreateCreditRequest> CreateCredit2(@RequestBody CreateCreditRequest createCreditRequest){


        return ResponseEntity.ok(creditService.createCredit(createCreditRequest));
    }

    @GetMapping("/getcredits")
    public List GetCredits(){
        return creditService.getCredits();
    }

    @GetMapping("/save")
    public void save(){
        creditService.save();
    }
}

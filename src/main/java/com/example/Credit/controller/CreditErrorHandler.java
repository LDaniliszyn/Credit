package com.example.Credit.controller;

import com.example.Credit.errorHandling.CustomerNotFoundException;
import com.example.Credit.errorHandling.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CreditErrorHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = {CustomerNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleCustomerNotFoundException(CustomerNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.builder().message("test").code("404").build());
    }
}
//resttemplate webclient


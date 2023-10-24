package com.transactionservice.controller;

import com.transactionservice.dto.request.TransactionRequestDto;
import com.transactionservice.dto.response.TransactionServiceResponse;
import com.transactionservice.exception.TransactionServiceApiException;
import com.transactionservice.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionServiceResponse> createTransaction(@Valid @RequestBody TransactionRequestDto transactionRequestDto) throws TransactionServiceApiException {
        return new ResponseEntity<>(TransactionServiceResponse.builder().result(transactionService.createTransaction(transactionRequestDto)).build(), HttpStatus.CREATED);
    }
}

package com.transactionservice.controller;

import com.transactionservice.dao.Transaction;
import com.transactionservice.dto.request.TransactionRequestDto;
import com.transactionservice.dto.response.TransactionServiceResponse;
import com.transactionservice.exception.ApiException;
import com.transactionservice.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/transactions")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public ResponseEntity<TransactionServiceResponse> createTransaction(@Valid @RequestBody TransactionRequestDto transactionRequestDto) throws ApiException {
        return new ResponseEntity<>(TransactionServiceResponse.builder().result(transactionService.createTransaction(transactionRequestDto)).build(), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<TransactionServiceResponse> getTransaction() throws ApiException {
        return new ResponseEntity<>(TransactionServiceResponse.builder().result(transactionService.getTransaction()).build(), HttpStatus.OK);
    }
}

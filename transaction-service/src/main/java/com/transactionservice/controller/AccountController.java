package com.transactionservice.controller;

import com.transactionservice.dto.request.AccountRequestDto;
import com.transactionservice.dto.response.TransactionServiceResponse;
import com.transactionservice.exception.TransactionServiceApiException;
import com.transactionservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public ResponseEntity<TransactionServiceResponse> createAccount(@Valid @RequestBody AccountRequestDto accountRequest) throws TransactionServiceApiException {
        return new ResponseEntity<>(TransactionServiceResponse.builder().result(accountService.createAccount(accountRequest)).build(), HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<TransactionServiceResponse> getAccount(@PathVariable Long accountId) throws TransactionServiceApiException {
        return new ResponseEntity<>(TransactionServiceResponse.builder().result(accountService.getAccount(accountId)).build(), HttpStatus.OK);
    }
}


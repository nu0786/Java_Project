package com.transactionservice.service;

import com.transactionservice.dto.request.AccountRequestDto;
import com.transactionservice.dto.response.AccountResponseDto;
import com.transactionservice.exception.TransactionServiceApiException;
import org.springframework.stereotype.Service;

@Service
public interface AccountService {

    boolean createAccount(AccountRequestDto accountRequest) throws TransactionServiceApiException;

    AccountResponseDto getAccount(Long accountId) throws TransactionServiceApiException;
}

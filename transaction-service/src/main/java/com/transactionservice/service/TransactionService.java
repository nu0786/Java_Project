package com.transactionservice.service;

import com.transactionservice.dto.request.TransactionRequestDto;
import com.transactionservice.exception.ApiException;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {

    boolean createTransaction(TransactionRequestDto transactionRequestDto) throws ApiException;
}

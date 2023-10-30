package com.transactionservice.service;

import com.transactionservice.dao.Transaction;
import com.transactionservice.dto.request.TransactionRequestDto;
import com.transactionservice.exception.ApiException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {

    boolean createTransaction(TransactionRequestDto transactionRequestDto) throws ApiException;

    List<Transaction> getTransaction() throws ApiException;
}

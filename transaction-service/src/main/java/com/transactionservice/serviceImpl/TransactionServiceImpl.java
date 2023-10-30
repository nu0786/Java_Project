package com.transactionservice.serviceImpl;

import com.transactionservice.constants.error.ApiErrors;
import com.transactionservice.dao.Account;
import com.transactionservice.dao.OperationType;
import com.transactionservice.dao.Transaction;
import com.transactionservice.dto.request.TransactionRequestDto;
import com.transactionservice.exception.ApiException;
import com.transactionservice.exception.ApiExceptionBuilder;
import com.transactionservice.repository.AccountRepository;
import com.transactionservice.repository.OperationTypeRepository;
import com.transactionservice.repository.TransactionRepository;
import com.transactionservice.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private OperationTypeRepository operationTypeRepository;

    @Override
    public boolean createTransaction(TransactionRequestDto transactionRequestDto) throws ApiException {

        Optional<Account> account = accountRepository.findById(transactionRequestDto.getAccountId());

        if( !account.isPresent() ) {
            throw ApiExceptionBuilder.build(ApiErrors.ACCOUNT_NOT_FOUND);
        }

        Optional<OperationType> operationType = operationTypeRepository.findById(transactionRequestDto.getOperationTypeId());

        if( !operationType.isPresent() ) {
            throw ApiExceptionBuilder.build(ApiErrors.OPERATION_TYPE_NOT_FOUND);
        }
        try{
            if( transactionRequestDto.getAmount() < 0 ) {
                Transaction transaction = new Transaction();
                transaction.setAccount(account.get());
                transaction.setOperationType(operationType.get());
                transaction.setAmount(transactionRequestDto.getAmount());
                transaction.setEventDate(LocalDateTime.now());
                transaction.setBalance(transactionRequestDto.getAmount());
                transactionRepository.save(transaction);
            }
            else{
                List<Transaction> negativeTransactions = transactionRepository.findNegativeTransactions(transactionRequestDto.getAccountId());

                Double remainingAmount = transactionRequestDto.getAmount();
                for( Transaction transaction: negativeTransactions ){
                    if( ( transaction.getBalance() * -1 ) <= remainingAmount ){
                        remainingAmount =  remainingAmount - ( transaction.getBalance() * -1 );
                        transaction.setBalance(0.0d);
                        transactionRepository.save(transaction);
                    }
                    else{
                        transaction.setBalance( remainingAmount - ( transaction.getBalance() * -1 ) );
                        remainingAmount = 0.0d;
                        transactionRepository.save(transaction);
                    }
                }
                Transaction transaction = new Transaction();
                transaction.setAccount(account.get());
                transaction.setOperationType(operationType.get());
                transaction.setAmount(transactionRequestDto.getAmount());
                transaction.setEventDate(LocalDateTime.now());
                transaction.setBalance(remainingAmount);
                transactionRepository.save(transaction);
            }
            return true;
        }
        catch(Exception e){
            throw ApiExceptionBuilder.build(ApiErrors.UNABLE_TO_SAVE_DATA);
        }
    }

    @Override
    public List<Transaction> getTransaction() throws ApiException{
        return transactionRepository.findAll();
    }
}

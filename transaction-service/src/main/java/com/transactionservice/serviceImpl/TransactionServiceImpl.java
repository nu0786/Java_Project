package com.transactionservice.serviceImpl;

import com.transactionservice.constants.ExceptionConstant;
import com.transactionservice.dao.Account;
import com.transactionservice.dao.OperationType;
import com.transactionservice.dao.Transaction;
import com.transactionservice.dto.request.TransactionRequestDto;
import com.transactionservice.exception.TransactionServiceApiException;
import com.transactionservice.repository.AccountRepository;
import com.transactionservice.repository.OperationTypeRepository;
import com.transactionservice.repository.TransactionRepository;
import com.transactionservice.service.TransactionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
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
    public boolean createTransaction(TransactionRequestDto transactionRequestDto) throws TransactionServiceApiException {

        try{

            Optional<Account> account = accountRepository.findById(transactionRequestDto.getAccountId());

            if( !account.isPresent() ) {
                throw new TransactionServiceApiException(ExceptionConstant.ACCOUNT_NOT_FOUND);
            }

            Optional<OperationType> operationType = operationTypeRepository.findById(transactionRequestDto.getOperationTypeId());

            if( !operationType.isPresent() ) {
                throw new TransactionServiceApiException(ExceptionConstant.OPERATION_TYPE_NOT_FOUND);
            }

            Transaction transaction = new Transaction();
            transaction.setAccount(account.get());
            transaction.setOperationType(operationType.get());
            transaction.setAmount(transactionRequestDto.getAmount());
            transaction.setEventDate(LocalDateTime.now());
            transactionRepository.save(transaction);

            return true;
        }
        catch(Exception e){
            throw new TransactionServiceApiException(ExceptionConstant.UNABLE_TO_SAVE_DATA);
        }
    }
}

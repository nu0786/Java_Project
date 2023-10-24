package com.transactionservice.serviceImpl;

import com.transactionservice.constants.ExceptionConstant;
import com.transactionservice.dao.Account;
import com.transactionservice.dto.request.AccountRequestDto;
import com.transactionservice.dto.response.AccountResponseDto;
import com.transactionservice.exception.TransactionServiceApiException;
import com.transactionservice.repository.AccountRepository;
import com.transactionservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public boolean createAccount(AccountRequestDto accountRequest) throws TransactionServiceApiException {

        try{

            Account account = new Account();
            account.setDocumentNumber(accountRequest.getDocumentNumber());
            accountRepository.save(account);
            return true;
        }
        catch(Exception e){
            throw new TransactionServiceApiException(ExceptionConstant.UNABLE_TO_SAVE_DATA);
        }
    }

    @Override
    public AccountResponseDto getAccount(Long accountId) throws TransactionServiceApiException {

        Optional<Account> account = accountRepository.findById(accountId);
        if( account.isPresent() ) {
            Account accountDetails = account.get();
            return AccountResponseDto.builder().accountId(accountDetails.getAccountId()).documentNumber(accountDetails.getDocumentNumber()).build();
        }
        throw new TransactionServiceApiException(ExceptionConstant.ACCOUNT_NOT_FOUND);
    }
}

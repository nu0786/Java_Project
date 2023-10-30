package com.transactionservice.repository;

import com.transactionservice.dao.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query(value = "SELECT t.* from transactions t WHERE t.account_id = :accountId and t.balance < 0",nativeQuery = true)
    List<Transaction> findNegativeTransactions(Long accountId);
}

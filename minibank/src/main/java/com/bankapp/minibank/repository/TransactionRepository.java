package com.bankapp.minibank.repository;

import com.bankapp.minibank.model.Transaction;
import com.bankapp.minibank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    // Custom method to get all transactions for a specific account
    List<Transaction> findByAccountOrderByTimestampDesc(Account account);

}

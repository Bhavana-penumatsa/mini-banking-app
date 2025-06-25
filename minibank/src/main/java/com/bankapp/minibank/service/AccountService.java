package com.bankapp.minibank.service;

import com.bankapp.minibank.model.Account;
import com.bankapp.minibank.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bankapp.minibank.repository.TransactionRepository;



@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account getAccount(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public String deposit(Long Id, double amount) {
        if (amount <= 0) {
            return "Deposit amount must be greater than zero.";
        }

        Account account = accountRepository.findById(Id)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account);

        // Optional: log a transaction too
        return "Amount deposited successfully.";
    }

    public String withdraw(Long accountId, double amount) {
        if (amount <= 0) {
            return "Withdraw amount must be greater than zero.";
        }

        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getBalance() < amount) {
            return "Insufficient balance.";
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account);

        // Optional: log a transaction too
        return "Amount withdrawn successfully.";
    }
}

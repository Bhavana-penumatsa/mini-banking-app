package com.bankapp.minibank.controller;

import com.bankapp.minibank.model.Account;
import com.bankapp.minibank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.bankapp.minibank.model.Transaction;
import com.bankapp.minibank.repository.TransactionRepository;
import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private TransactionRepository transactionRepository;


    // 1. Create account
    @PostMapping
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    // 2. Get account details
    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) {
        return accountService.getAccount(id);
    }

    // 3. Deposit money
    @PostMapping("/{id}/deposit")
    public String deposit(@PathVariable Long id, @RequestParam Double amount) {
        return accountService.deposit(id, amount);
    }

    // 4. Withdraw money
    @PostMapping("/{id}/withdraw")
    public String withdraw(@PathVariable Long id, @RequestParam Double amount) {
        return accountService.withdraw(id, amount);
    }

    @GetMapping("/")
    public String home() {
        return "Welcome to Mini Banking App!";
    }

    @GetMapping("/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable Long id) {
        Account account = accountService.getAccount(id);
        if (account != null) {
            return transactionRepository.findByAccountOrderByTimestampDesc(account);
        } else {
            return List.of(); // return empty list if account doesn't exist
        }
    }

}

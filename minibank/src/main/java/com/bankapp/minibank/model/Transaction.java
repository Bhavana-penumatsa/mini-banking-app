package com.bankapp.minibank.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type; // DEPOSIT or WITHDRAW
    private Double amount;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;

    public Transaction() {}

    public Transaction(String type, Double amount, LocalDateTime timestamp, Account account) {
        this.type = type;
        this.amount = amount;
        this.timestamp = timestamp;
        this.account = account;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

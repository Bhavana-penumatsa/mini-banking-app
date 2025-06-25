package com.bankapp.minibank.repository;

import com.bankapp.minibank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    // No need to write any code here - Spring gives save(), findById(), deleteById(), etc.
}

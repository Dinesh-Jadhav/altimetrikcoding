package com.altimetrik.Interviewtest.service;

import com.altimetrik.Interviewtest.entity.Account;
import com.altimetrik.Interviewtest.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;

    public List<Account> getAccountByUserId(String userId){
        return accountRepository.findByUserId(userId);
    }

    public Account createAccount(Account account){
        account.setBalance(0);
        return accountRepository.save(account);
    }

    public Account updateAccountBalance(String accountId, double amount){
        Account account = accountRepository.findById(accountId).orElseThrow();
        account.setBalance(account.getBalance()+amount);
        return accountRepository.save(account);
    }
}

package com.altimetrik.Interviewtest.service;

import com.altimetrik.Interviewtest.entity.Transaction;
import com.altimetrik.Interviewtest.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    AccountService accountService;

    public List<Transaction> getAllTransactionByAccountId(String accountId){
        return transactionRepository.findByAccountId(accountId);
    }

    public Transaction saveTrasaction( Transaction transaction){
        if(Objects.equals(transaction.getTransactionType(), "DEPOSIT")){
            accountService.updateAccountBalance(transaction.getAccountId(), transaction.getAmount());
        }else {
            accountService.updateAccountBalance(transaction.getAccountId(), -transaction.getAmount());
        }
        return transactionRepository.save(transaction);
    }

}

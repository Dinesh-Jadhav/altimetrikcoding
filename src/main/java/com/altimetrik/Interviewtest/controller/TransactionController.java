package com.altimetrik.Interviewtest.controller;

import com.altimetrik.Interviewtest.entity.Transaction;
import com.altimetrik.Interviewtest.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;
    @GetMapping("/account/{accountId}")
    public List<Transaction> getAllTransactionsByAccountId(@PathVariable String accountId){

        return transactionService.getAllTransactionByAccountId(accountId);
    }

    @PostMapping
    public Transaction CreateTransaction(@RequestBody Transaction transaction){
        return transactionService.saveTrasaction(transaction);
    }
}

package com.altimetrik.Interviewtest.controller;

import com.altimetrik.Interviewtest.entity.Account;
import com.altimetrik.Interviewtest.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/api/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/user/{userId}")
    public List<Account> getAccountByUserId(@PathVariable String userId){
        return accountService.getAccountByUserId(userId);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

}

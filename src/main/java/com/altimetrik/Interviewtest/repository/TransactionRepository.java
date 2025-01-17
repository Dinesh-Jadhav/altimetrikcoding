package com.altimetrik.Interviewtest.repository;

import com.altimetrik.Interviewtest.entity.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction,String> {
    List<Transaction> findByAccountId(String accountId);
}

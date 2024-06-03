package com.altimetrik.Interviewtest.repository;

import com.altimetrik.Interviewtest.entity.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AccountRepository extends MongoRepository<Account, String> {

    List<Account> findByUserId(String userId);
}

package com.altimetrik.Interviewtest.repository;

import com.altimetrik.Interviewtest.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User,String> {
    @Query("{username:?0}")
    User findAllByUsername(String username);

}

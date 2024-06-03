package com.altimetrik.Interviewtest.service;


import com.altimetrik.Interviewtest.entity.User;
import com.altimetrik.Interviewtest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findAllByUsername(username);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
}

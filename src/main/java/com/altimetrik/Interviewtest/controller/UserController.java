package com.altimetrik.Interviewtest.controller;

import com.altimetrik.Interviewtest.dto.AuthenticationRequestDto;
import com.altimetrik.Interviewtest.entity.User;
import com.altimetrik.Interviewtest.security.jwt.JwtUtil;
import com.altimetrik.Interviewtest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody User user){
        User userData = userService.getUserByUsername(user.getUsername());
        if(userData!=null){
            return ResponseEntity.ok("User already register with same name ");
        }else{
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("ROLE_USER");
        userService.saveUser(user);
        return ResponseEntity.ok("User registered successfully !!!");
        }

    }


    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequestDto authenticationRequest) throws Exception{
             User userDetails = userService.getUserByUsername(authenticationRequest.getUsername());
             String jwt = jwtUtil.generateToken(userDetails);

        return ResponseEntity.ok(jwt);
    }

    @GetMapping("/{username}")
    public User getUserByname(@PathVariable String username)
    {
        return userService.getUserByUsername(username);
    }



}

package com.altimetrik.Interviewtest.entity;

import lombok.Data;
import lombok.Generated;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "users")
@Data
public class User {
    @Id
    private String Id;
    private String username;
    private String password;
    private String role;// AMDIN,USER
}

package com.altimetrik.Interviewtest.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "account")
@Data
public class Account {
  @Id
  private String id;
  private String userId;
  private String accountType;
  private double balance;
}

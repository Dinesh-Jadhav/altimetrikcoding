package com.altimetrik.Interviewtest.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transactions")
@Data
public class Transaction {
    @Id

    private String id;
    private String accountId;
    private String transactionType; //DEPOSIT, WITHDRAWAL
    private double amount;
    private String type;

}

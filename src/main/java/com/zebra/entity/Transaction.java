package com.zebra.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;


@Entity
@Table(name = "transactions")
public class Transaction {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    private BigDecimal amount;
    private String category;
    private long csvID;
    public Transaction() {}
    public Transaction(Long id, String description, BigDecimal amount, String category, Long csvID) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.csvID = csvID;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public long getCsvID() {
        return csvID;
    }

    public void setCsvID(Long csvID) {
        this.csvID = csvID;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}

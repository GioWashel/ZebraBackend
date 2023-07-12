package com.zebra.service;

import com.zebra.entity.Csv;
import com.zebra.entity.Transaction;

import java.math.BigDecimal;

public interface TransactionServiceInterface {
    public Transaction getTransaction(Transaction transaction);
    public Transaction postTransaction(Transaction transaction);
    public Transaction updateCategory(Transaction transaction, String category);
    public Transaction updateAmount(Transaction transaction, BigDecimal amount);
    public Transaction updateDescription(Transaction transaction, String description);
}

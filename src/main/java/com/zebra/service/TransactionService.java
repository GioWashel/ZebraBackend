package com.zebra.service;


import com.zebra.entity.Csv;
import com.zebra.entity.Transaction;
import com.zebra.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class TransactionService implements TransactionServiceInterface {
    public TransactionRepository transactionRepository;

    @Autowired
    TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public Transaction getTransaction(Transaction transaction) {
        return transactionRepository.getReferenceById(transaction.getId());
    }

    @Override
    public Transaction postTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);

    }

    @Override
    public Transaction updateCategory(Transaction transaction, String category) {
        transaction.setCategory(category);
        return transactionRepository.save(transaction);
    }

    @Override
    public Transaction updateAmount(Transaction transaction, BigDecimal amount) {
        transaction.setAmount(amount);
        return transactionRepository.save(transaction);

    }

    @Override
    public Transaction updateDescription(Transaction transaction, String description) {
        transaction.setDescription(description);
        return transactionRepository.save(transaction);
    }
}

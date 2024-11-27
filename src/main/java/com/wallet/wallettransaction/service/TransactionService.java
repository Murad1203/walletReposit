package com.wallet.wallettransaction.service;

import com.wallet.wallettransaction.model.Transaction;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TransactionService {
    void createTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
    Transaction getTransactionById(String id);
}

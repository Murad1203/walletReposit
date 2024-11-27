package com.wallet.wallettransaction.service.imp;

import com.wallet.wallettransaction.exception.TransactionNotFoundException;
import com.wallet.wallettransaction.model.Transaction;
import com.wallet.wallettransaction.repository.TransactionRepository;
import com.wallet.wallettransaction.service.TransactionService;
import jakarta.transaction.TransactionalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class TransactionalServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void createTransaction(Transaction transaction) {
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(id).orElseThrow(() -> new TransactionNotFoundException("Transaction not foud with id: " + id));
    }
}

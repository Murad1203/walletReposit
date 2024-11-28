package com.wallet.wallettransaction.service.imp;

import com.wallet.wallettransaction.exception.TransactionNotFoundException;
import com.wallet.wallettransaction.model.Transaction;
import com.wallet.wallettransaction.repository.TransactionRepository;
import com.wallet.wallettransaction.service.TransactionService;
import jakarta.transaction.TransactionalException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class TransactionalServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Override
    public void createTransaction(Transaction transaction) {
        transaction.setDateTime(LocalDateTime.now());
        transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionRepository.findAll();
    }

    @Override
    public Transaction getTransactionById(String id) {
        return transactionRepository.findById(UUID.fromString(id)).orElseThrow(() -> new TransactionNotFoundException("Transaction not foud with id: " + id));
    }
}

package com.wallet.wallettransaction.controller;

import com.wallet.wallettransaction.exception.InsufficientFundsException;
import com.wallet.wallettransaction.model.OperationType;
import com.wallet.wallettransaction.model.Transaction;
import com.wallet.wallettransaction.model.Wallet;
import com.wallet.wallettransaction.service.TransactionService;
import com.wallet.wallettransaction.service.WalletService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController("api/v1")
@Log4j2
public class WalletController {

    @Autowired
    private WalletService walletService;

    @Autowired
    private TransactionService transactionService;


    @PostMapping("/create-wallet")
    public Wallet createWallet(Wallet wallet) {
        walletService.createWallet(wallet);
        return wallet;
    }

    @PostMapping("/wallet")
    public Transaction postTransaction(Transaction transaction) throws InsufficientFundsException {
        if (transaction.getOperationType().equals(OperationType.DEPOSIT)) {
            walletService.deposit(transaction.getAmount(), transaction.getWallet());
        }
        else if (transaction.getOperationType().equals(OperationType.WITHDRAW)) {
            walletService.withDraw(transaction.getAmount(), transaction.getWallet());
        }
        else {
            log.error("Doesn't not find Operation type is " + transaction.getOperationType());
        }
        transactionService.createTransaction(transaction);
        return transaction;
    }

    @GetMapping("/wallets/{id}")
    public BigDecimal getBalance(@PathVariable String id) {
        return walletService.getWalletById(id).getBalance();
    }

}

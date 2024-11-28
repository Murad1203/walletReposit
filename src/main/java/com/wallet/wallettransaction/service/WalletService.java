package com.wallet.wallettransaction.service;

import com.wallet.wallettransaction.exception.InsufficientFundsException;
import com.wallet.wallettransaction.model.Wallet;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;


public interface WalletService {
    Wallet getWalletById(UUID id);
    List<Wallet> getAllWallet();
    void createWallet(Wallet wallet);
    void deleteWallet(UUID id);
    void updateWallet();
    void deposit(BigDecimal amount, UUID walletId);
    void withDraw(BigDecimal amount, UUID walletId) throws InsufficientFundsException;
}

package com.wallet.wallettransaction.service;

import com.wallet.wallettransaction.exception.InsufficientFundsException;
import com.wallet.wallettransaction.model.Wallet;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public interface WalletService {
    Wallet getWalletById(String id);
    List<Wallet> getAllWallet();
    void createWallet(Wallet wallet);
    void deleteWallet(String id);
    void updateWallet();
    void deposit(BigDecimal amount, String walletId);
    void withDraw(BigDecimal amount, String walletId) throws InsufficientFundsException;
}

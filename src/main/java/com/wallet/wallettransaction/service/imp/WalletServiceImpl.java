package com.wallet.wallettransaction.service.imp;

import com.wallet.wallettransaction.exception.InsufficientFundsException;
import com.wallet.wallettransaction.exception.WalletNotFundException;
import com.wallet.wallettransaction.model.Wallet;
import com.wallet.wallettransaction.repository.WalletRepository;
import com.wallet.wallettransaction.service.WalletService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;


public class WalletServiceImpl implements WalletService {

    @Autowired
    private WalletRepository walletRepository;

    @Override
    public Wallet getWalletById(String id) {
        return walletRepository.findById(id).orElseThrow(() -> new WalletNotFundException("Wallet not found with id: " + id));
    }

    @Override
    public List<Wallet> getAllWallet() {
        return walletRepository.findAll();
    }

    @Override
    public void createWallet(Wallet wallet) {
        walletRepository.save(wallet);
    }

    @Override
    public void deleteWallet(String id) {
        walletRepository.deleteById(id);
    }

    @Override
    public void updateWallet() {

    }

    @Override
    @Transactional
    public void deposit(BigDecimal amount, String walletId) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new WalletNotFundException("Wallet not funds with id: " + walletId));
        wallet.setBalance(wallet.getBalance().add(amount));
        walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public void withDraw(BigDecimal amount, String walletId) throws InsufficientFundsException {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow(() -> new WalletNotFundException("Wallet not found with id: " + walletId));
        if (wallet.getBalance().compareTo(amount) == -1) {
            throw new InsufficientFundsException("InsufficientFundsException funds in wallet id: " + walletId);
        }
        wallet.setBalance(wallet.getBalance().subtract(amount));
        walletRepository.save(wallet);
    }
}

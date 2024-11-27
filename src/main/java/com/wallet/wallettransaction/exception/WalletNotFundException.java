package com.wallet.wallettransaction.exception;

public class WalletNotFundException extends RuntimeException {
    public WalletNotFundException(String message) {
        super(message);
    }
}

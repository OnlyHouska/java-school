package org.delta.acounts;

import com.google.inject.Singleton;

@Singleton
public class SlovakiaBankAccountNumberGenerator implements AccountNumberGenerator {

    @Override
    public String generateBankAccountNumber() {
        return "SLOVAKIA BANK ACCOUNT NUMBER";
    }
}

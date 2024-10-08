package org.delta.print;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.delta.acounts.BankAccount;

public class SlfAccountDetailPrinted implements DetailPrinter {

    private static Logger logger = LoggerFactory.getLogger(SlfAccountDetailPrinted.class);

    @Override
    public void printDetail(BankAccount account) {
        logger.error(PrinterUtils.getPrefix(account) + " Bank account balance: " + account.getBalance());
    }

    @Override
    public void printDetail(BankAccount account, double fee) {
        logger.error(PrinterUtils.getPrefix(account) + " Bank account balance: " + account.getBalance() + ", fee " + fee);
    }
}

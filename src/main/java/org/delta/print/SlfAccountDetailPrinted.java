package org.delta.print;

import com.google.inject.Singleton;
import org.delta.accounts.cards.BankCard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.delta.accounts.BankAccount;

import java.util.Map;

@Singleton
public class SlfAccountDetailPrinted implements DetailPrinter {

    private static Logger logger = LoggerFactory.getLogger(SlfAccountDetailPrinted.class);

    @Override
    public void printDetail(BankAccount account) {
        logger.error(PrinterUtils.getPrefix(account) + " Bank account balance: " + account.getBalance());

        this.printCards(account);

    }

    @Override
    public void printDetail(BankAccount account, double fee) {
        logger.error(PrinterUtils.getPrefix(account) + " Bank account balance: " + account.getBalance() + ", fee " + fee);

        this.printCards(account);
    }

    private void printCards(BankAccount account) {
        for (Map.Entry<String, BankCard> entrySet : account.getCards().entrySet()) {
            logger.error(entrySet.getKey() + ": " + entrySet.getValue().getNumber() + ": " + entrySet.getValue().getPin());
        }
    }
}

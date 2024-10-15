package org.delta;

import com.google.inject.AbstractModule;
import org.delta.accounts.AccountNumberGenerator;
import org.delta.accounts.SlovakiaBankAccountNumberGenerator;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.print.AccountDetailPrinter;
import org.delta.print.DetailPrinter;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);

        this.bind(DetailPrinter.class).to(AccountDetailPrinter.class);

        this.bind(BankCardFactory.class);
    }
}

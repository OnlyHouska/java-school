package org.delta;

import com.google.inject.AbstractModule;
import org.delta.acounts.AccountNumberGenerator;
import org.delta.acounts.SlovakiaBankAccountNumberGenerator;
import org.delta.persons.PersonGsonSerializationService;
import org.delta.persons.PersonSerializationService;
import org.delta.print.DetailPrinter;
import org.delta.print.SlfAccountDetailPrinted;

public class BankInjector extends AbstractModule {

    @Override
    protected void configure() {
        this.bind(AccountNumberGenerator.class).to(SlovakiaBankAccountNumberGenerator.class);
        this.bind(DetailPrinter.class).to(SlfAccountDetailPrinted.class);
        this.bind(PersonSerializationService.class).to(PersonGsonSerializationService.class);
    }
}

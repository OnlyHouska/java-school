package org.delta;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.acounts.*;
import org.delta.persons.*;
import org.delta.print.DetailPrinter;
import org.delta.print.SlfAccountDetailPrinted;

@Singleton
public class DIContainer {

    private AccountNumberGenerator bankAccountNumberGenerator = new SlovakiaBankAccountNumberGenerator();
    private TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    private DetailPrinter accountDetailPrinter = new SlfAccountDetailPrinted();
    private PersonIdValidator personIdValidator = new PersonIdValidator();
    private MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);
    private OwnerFactory ownerFactory = new OwnerFactory(bankAccountNumberGenerator, personIdValidator);

    @Inject
    private BankAccountFactory bankAccountFactory;

    private PersonSerializationService personJsonSerializationService = new PersonGsonSerializationService();

    public AccountNumberGenerator getBankAccountNumberGenerator() {
        return bankAccountNumberGenerator;
    }

    public TransferFeeCalculator getTransferFeeCalculator() {
        return transferFeeCalculator;
    }

    public DetailPrinter getAccountDetailPrinter() {
        return accountDetailPrinter;
    }

    public PersonIdValidator getPersonIdValidator() {
        return personIdValidator;
    }

    public MoneyTransferService getMoneyTransferService() {
        return moneyTransferService;
    }

    public OwnerFactory getOwnerFactory() {
        return ownerFactory;
    }

    public BankAccountFactory getBankAccountFactory() {
        return bankAccountFactory;
    }

    public PersonSerializationService getPersonJsonSerializationService() {
        return personJsonSerializationService;
    }
}

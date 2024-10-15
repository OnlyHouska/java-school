package org.delta;

import org.delta.acounts.*;
import org.delta.persons.OwnerFactory;
import org.delta.persons.PersonIdValidator;
import org.delta.print.DetailPrinter;
import org.delta.print.SlfAccountDetailPrinted;

public class DIContainer {

    private AccountNumberGenerator bankAccountNumberGenerator = new SlovakiaBankAccountNumberGenerator();
    private TransferFeeCalculator transferFeeCalculator = new TransferFeeCalculator();
    private DetailPrinter accountDetailPrinter = new SlfAccountDetailPrinted();
    private PersonIdValidator personIdValidator = new PersonIdValidator();
    private MoneyTransferService moneyTransferService = new MoneyTransferService(transferFeeCalculator, accountDetailPrinter);
    private OwnerFactory ownerFactory = new OwnerFactory(bankAccountNumberGenerator, personIdValidator);
    private BankAccountFactory bankAccountFactory = new BankAccountFactory(bankAccountNumberGenerator);

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
}

package org.delta.accounts;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.cards.BankCard;
import org.delta.persons.Owner;

import java.util.HashMap;
import java.util.Map;

public class BankAccount {
    private final String accountNumber;
    private double balance;
    private final Owner owner;

    private final Map<String, BankCard> cardsInMap;

    private GlobalCardStorage globalCardStorage;

    public BankAccount(String accountNumber, double balance, Owner owner) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.owner = owner;
        cardsInMap = new HashMap<String, BankCard>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void getInfo(){
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("Owner: " + owner.getName());
        System.out.println("Cards: ");

        for (BankCard card : cardsInMap.values()) {
            System.out.println(card.getNumber());
        }
    }

    public BankCard getCard(String cardNumber){
        return cardsInMap.get(cardNumber);
    }

    public int getAmountOfBankCards(){
        return cardsInMap.size();
    }

    public void assignNewCard(BankCard bankCard){
        cardsInMap.put(bankCard.getNumber(), bankCard);
    }

    public Map<String, BankCard> getCards() {
        return cardsInMap;
    }
}
package org.delta.acounts.cards;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class BankCardPinGenerator {
    public String generate() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        for (int i = 0; i < 4; i++) {
            cardNumber.append(random.nextInt(10));
        }

        return cardNumber.toString();
    }
}

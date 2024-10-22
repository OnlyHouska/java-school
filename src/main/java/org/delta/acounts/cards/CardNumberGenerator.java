package org.delta.acounts.cards;

import com.google.inject.Singleton;

import java.util.Random;

@Singleton
public class CardNumberGenerator {

    public String generate() {
        Random random = new Random();
        StringBuilder cardNumber = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            if (i > 0 && i % 4 == 0) {
                cardNumber.append("-");
            }

            cardNumber.append(random.nextInt(10));
        }

        return cardNumber.toString();
    }


}

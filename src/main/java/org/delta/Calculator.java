package org.delta;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.delta.accounts.Interesting;
import org.delta.accounts.SavingBankAccount;

@Singleton
public class Calculator implements Calc {

    @Inject Interesting interesting;

    @Override
    public double add(double a, double b) {
        return a + b;
    }

    @Override
    public double sub(double a, double b) {
        return a - b;
    }

    @Override
    public double mul(double a, double b) {
        return a * b;
    }

    @Override
    public double div(double a, double b) {

        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }

        return a / b;
    }

    public double Interest(double balance) {
        return balance * interesting.getInterest() / 100;
    }
}

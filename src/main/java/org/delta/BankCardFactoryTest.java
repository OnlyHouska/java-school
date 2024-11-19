package org.delta;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.delta.accounts.BankAccount;
import org.delta.accounts.BankAccountFactory;
import org.delta.accounts.cards.BankCard;
import org.delta.accounts.cards.BankCardFactory;
import org.delta.persons.Owner;
import org.delta.persons.OwnerFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class BankCardFactoryTest {
    Injector i = Guice.createInjector(new BankInjector());
    private OwnerFactory ownerFactory;
    private BankAccountFactory bankAccountFactory;
    private BankCardFactory bankCardFactory;
    @BeforeEach
    public void setUp() {
        ownerFactory = i.getInstance(OwnerFactory.class);
        bankAccountFactory = i.getInstance(BankAccountFactory.class);
        bankCardFactory = i.getInstance(BankCardFactory.class);
    }
    @Test
    @DisplayName("Bank card generator test")
    void createBankCard() throws Exception {
        Owner ownerTest = this.ownerFactory.createOwner("Jan", "Kocanda", "777");
        assertEquals(ownerTest.getName(), "Jan");
        assertEquals(ownerTest.getSurname(), "Kocanda");
        assertEquals(ownerTest.getId(), "777");
        BankAccount testBankAccount = this.bankAccountFactory.createBankAccount(100, ownerTest);
        assertEquals(testBankAccount.getBalance(), 100);
        BankCard bankCardTest = this.bankCardFactory.createBankCard(testBankAccount);
    }
}
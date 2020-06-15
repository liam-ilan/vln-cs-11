import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.Date;

public class DepositTests {
    Deposit testDeposit;
    double amount;
    Date date;
    String account;

    @Before
    public void setup(){
        amount = 10;
        date = new Date();
        account = Customer.CHECKING;

        testDeposit = new Deposit(amount, date, account);
    }

    @Test
    public void testToString(){
        String depositString = testDeposit.toString();
        assertEquals("Deposit of: $" + amount + " Date: " + date + " into account: " + account, depositString);
    }
}
